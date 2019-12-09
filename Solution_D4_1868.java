package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868 {
	static int TC, N;
	static char[][] map;
	static int[] di = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dj = { 1, 0, -1, 0, -1, 1, 1, -1 };
	static int[][] intmap;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			intmap = new int[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			Queue<Point> que = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = 0;
					for (int d = 0; d < 8; d++) {
						int nexti = i + di[d];
						int nextj = j + dj[d];
//						System.out.println(nexti+ ","+nextj);
						if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && intmap[i][j] != -1) {
							if (map[nexti][nextj] == '*') {
								count++;
							}
						}
					}
					if (map[i][j] != '*') {
						intmap[i][j] = count;
					}
					if (map[i][j] == '*')
						intmap[i][j] = -1;
				}
			}
//			print();
//			System.out.println("-======-");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (intmap[i][j] == 0) {
						// bfs 실시
						que.add(new Point(i, j));
						while (!que.isEmpty()) {
							Point p = que.poll();
							intmap[p.i][p.j] = -1;

							for (int d = 0; d < 8; d++) {
								int nexti = p.i + di[d];
								int nextj = p.j + dj[d];
								if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && intmap[nexti][nextj] != -1) {
									// 움직일수 있어 움직여
									if (intmap[nexti][nextj] == 0) {
										que.add(new Point(nexti, nextj));
									}
									intmap[nexti][nextj] = -1;
								}
							}
						}
						answer++;
					}
				}
			}
			counting();
			System.out.println("#"+tc+ " "+answer);
		}
	}

	static public void counting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(intmap[i][j]!=-1) {
					answer++;
				}
			}
		}
	}

	static public class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
