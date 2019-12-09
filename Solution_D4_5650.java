package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_5650 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 }; // 상 좌 하 우
	static int TC, N;
	static int[][] map;
	static final int EMPTY = 0;
	static int max = 0;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N + 2][N + 2];
			max = 0;
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i <= N + 1; i++) {
				map[i][0] = 5;
				map[0][i] = 5;
				map[i][N + 1] = 5;
				map[N + 1][i] = 5;
			}

//          for (int i = 0; i <= N + 1; i++) {
//              for (int j = 0; j <= N + 1; j++) {
//                  System.out.print(map[i][j] + " ");
//              }
//              System.out.println();
//          }
 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == EMPTY) { // 핀볼을 놓아보자 4방향으로
						map[i][j] = -1; // 블랙홀로 만들어 놓기.
						move(i, j);
						map[i][j] = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	public static void move(int ii, int jj) {
		// 핀볼을 움직이기 위한 함수.(4방향으로)?
		Ball b = null;
		for (int d = 0; d < 4; d++) {
			b = new Ball(ii, jj, d, 0);
			// 빈곳이 아닌곳 까지 움직여보기
			while(true) {
				while (true) {
					b.i += di[b.dir];
					b.j += dj[b.dir];
					if (map[b.i][b.j] != EMPTY)
						break;
				}
				if (map[b.i][b.j] == -1) {// 블랙홀이면
					max = Math.max(b.count, max);
					break;
				} else if (map[b.i][b.j] <= 5) {// 블록이면
					b.count++;
					int cdir =changeDir(map[b.i][b.j],b.dir); 
					b.dir = cdir;
				} else if (map[b.i][b.j] >= 6) { // 웜홀이면
					changeIJ(map[b.i][b.j] , b.i,b.j , b);
				}
				
			}
		}
	}

	private static void changeIJ(int warm, int nexti, int nextj, Ball b) {

		for (int i = 1; i <= N + 1; i++) {
			for (int j = 1; j <= N + 1; j++) {
				if (warm == map[i][j]) {
					if (!(nexti == i && nextj == j)) {
						b.i = i;
						b.j = j;
					}
				}
			}
		}

	}

	private static int changeDir(int wall, int dir) {
		if (wall == 1) {
			if (dir == 2) {
				return 1;
			} else if (dir == 3) {
				return 0;
			} else if (dir == 0) {
				return 2;
			} else {
				return 3;
			}
		} else if (wall == 2) {
			if (dir == 2) {
				return 0;
			} else if (dir == 3) {
				return 2;
			} else if (dir == 0) {
				return 1;
			} else {
				return 3;
			}
		} else if (wall == 3) {
			if (dir == 2) {
				return 0;
			} else if (dir == 3) {
				return 1;
			} else if (dir == 0) {
				return 3;
			} else {
				return 2;
			}
		} else if (wall == 4) {
			if (dir == 2) {
				return 3;
			} else if (dir == 3) {
				return 1;
			} else if (dir == 0) {
				return 2;
			} else {
				return 0;
			}
		} else {
			if (dir == 2) {
				return 0;
			} else if (dir == 3) {
				return 1;
			} else if (dir == 0) {
				return 2;
			} else {
				return 3;
			}
		}
	}

	static class Ball {
		int i, j;
		int dir;
		int count;

		Ball(int i, int j, int dir, int count) {
			this.i = i;
			this.j = j;
			this.dir = dir;
			this.count = count;
		}
	}
}