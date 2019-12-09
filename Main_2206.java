package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
	static int N, M;
	static int[][] map = new int[1001][1001];
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static Queue<Node> que;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (line[j] - '0' == 1)
					visited[i][j] = true;
				map[i][j] = line[j] - '0';
			}
		}
		que = new LinkedList<>();
		que.add(new Node(0, 0, true, 1));
		// BFS
		while (!que.isEmpty()) {
			Node now = que.poll(); 
			//4방향 탐색
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d]; //다음 i
				int nextj = now.j + dj[d]; //다음 j
				if (nexti == N - 1 && nextj == M - 1) { // 종료조건;
					System.out.println(now.count+1);
					System.exit(0);
				}
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M) { //그안에 존재한다면,
					if(now.flag) {//내가 벽을 뿌실수 있다면
						if(map[nexti][nextj] == 0) {
							que.add(new Node(nexti, nextj, true, now.count + 1)); 
							map[now.i][now.j] = -1; 
							continue;
						}else if(map[nexti][nextj] == 1) {
							que.add(new Node(nexti, nextj, false, now.count + 1)); 
							map[now.i][now.j] = -1;
							continue;
						}
					}else {//벽을 부실수 없다면?
						if(map[nexti][nextj] == 0) {
							que.add(new Node(nexti, nextj, false, now.count + 1)); 
							map[now.i][now.j] = -1; 
							continue;
						}					
					}

				}
			}

		}
		System.out.println(-1);
	}

	public static class Node {
		int i, j, count;
		boolean flag;

		Node(int i, int j, boolean flag, int count) {
			this.i = i;
			this.j = j;
			this.flag = flag;
			this.count = count;
		}
	}
}
