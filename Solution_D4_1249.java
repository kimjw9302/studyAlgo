package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_D4_1249 {
	static int TC, N;
	static int[][] map;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				String line = br.readLine();
				for (int i = 0; i < N; i++) {
					map[j][i] = line.charAt(i) - '0';
				}
			}
			PriorityQueue<Info> pq = new PriorityQueue<>();
			pq.add(new Info(0, 0, 0));
			visited[0][0]=true;
			while (!pq.isEmpty()) {
				Info now = pq.poll();
				if(now.i==N-1 && now.j==N-1) {
					min = Math.min(min, now.sum);
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					if(nexti>=0&&nexti<N&&nextj>=0&&nextj<N&&!visited[nexti][nextj]) {
							visited[now.i][now.j] = true;
//							System.out.println(nexti+ " , "+nextj +"비용 : "+map[nexti][nextj] + " 총비용 : "+now.min);
							pq.add(new Info(nexti,nextj,now.sum+map[nexti][nextj]));
					}
				}
			}
			System.out.println("#" + tc + " " + min);
		}
	}

	static class Info implements Comparable<Info> {
		int i, j;
		int sum;
		Info(int i, int j, int sum) {
			this.i = i;
			this.j = j;
			this.sum = sum;
		}

		@Override
		public int compareTo(Info o) {
			return this.sum-o.sum;
		}

	}
}
