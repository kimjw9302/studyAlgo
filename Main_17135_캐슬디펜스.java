package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_17135_캐슬디펜스 {
	static int N, M, D;
	static ArrayList<Pos> our;
	static int[][] map;
	static int answer;
	static int sum;
	static boolean[] visited;
	static int[][] tempmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		tempmap = new int[N+1][M];
		visited = new boolean[M];
		our = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tempmap[i][j] = map[i][j];
			}
		}
		setArchor(3, 0, N, 0);
		System.out.println(answer);
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void setArchor(int tot, int idx, int ni, int nj) {
		if (tot == idx) {
			answer = Math.max(answer, 0);
			for(int i = 0 ; i < M ; i++) {
				if(visited[i]) {
					our.add(new Pos(N, i,0));
				}
			}
			copy();
			bfs();
			our.clear();

		    answer = Math.max(answer, sum);
			return;
		}
		for (int j = nj; j < M; j++) {
			if (!visited[j]) {
				visited[j] = true;
				setArchor(3, idx + 1, N, j);
				visited[j] = false;
			}
		}
	}
	private static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempmap[i][j] = map[i][j];
			}
		}
	}
	private static void bfs() {
//		System.out.println(our);
//		System.out.println("=====");
		sum=0;
		for(int n = 0 ; n < N; n++) {
			shoot();
			mapdown();
		}
	}
	private static void shoot() {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };
		boolean[][] shoot = new boolean[N][M];
		for(int i = 0 ; i <3 ; i++) {
			Queue<Pos> que = new LinkedList<>();
			PriorityQueue<Pos> enemy = new PriorityQueue<>();
			boolean[][] used = new boolean[N][M];
			que.add(our.get(i));
			int dis = 0;
			while(!que.isEmpty()&&dis<D) {
				int size = que.size();
				for(int s = 0 ; s<size ;s++) {
					Pos now = que.poll();
					for(int d = 0 ; d<4;d++) {
						int nexti = now.i + di[d];
						int nextj = now.j + dj[d];
						if(nexti>=0 && nexti<N && nextj>=0 && nextj<M&&!used[nexti][nextj]) {
							if(tempmap[nexti][nextj] == 0) {
							used[nexti][nextj] = true;
								que.add(new Pos(nexti,nextj,now.cnt+1));
							} 
							else if(tempmap[nexti][nextj] == 1) {
								enemy.add(new Pos(nexti,nextj,now.cnt+1));
								used[nexti][nextj] = true;
								que.add(new Pos(nexti,nextj,now.cnt+1));
							} 
						}
					}
				}
				dis++;
				if(!enemy.isEmpty()) {
					   Pos target = enemy.poll();
		               shoot[target.i][target.j]= true;
		               break;      //while bfs 나가서 archer for로 나간다.

				}
			}
		}
//		print(tempmap);
//		System.out.println("==");
	    for (int i = 0; i < N; i++) {
	         for (int j = 0; j < M; j++) {
	            if(shoot[i][j]) {
	               sum++;
	               tempmap[i][j]= 0;
	            }
	         }
	      }
	}
	private static void mapdown() {
		for (int i = N - 1; i >= 1; i--) {
			for(int j  = 0 ; j < M ; j++) {
				tempmap[i][j] = tempmap[i - 1][j];
			}
		}
		Arrays.fill(tempmap[0], 0);
	}
	static class Pos implements Comparable<Pos> {
		int i, j;
		boolean isDie = true;
		int cnt;
		Pos(int i, int j,int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Pos [i=" + i + ", j=" + j + ", isDie=" + isDie + "]";
		}
		@Override
		public int compareTo(Pos o) {
				return this.j - o.j;
		}
	}
}