package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16988 {
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static final int BLACK = 2;
	static final int WHITE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		LinkedList<Pair> possibleList = new LinkedList<>();
		// 하얀돌 두개둘거야! (하나고정후 다른것들 고정)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isPossible(i, j)) {
//					System.out.println(i + " , " + j + " 들어가유");
					possibleList.add(new Pair(i, j));
				}
			}
		}
		int max = 0;
		for (int i = 0; i < possibleList.size() - 1; i++) {
			Pair pair1 = possibleList.get(i);
			for (int j = i + 1; j < possibleList.size(); j++) {
				Pair pair2 = possibleList.get(j);
				modiMap(pair1, pair2); // 흑 -> 백, 백 -> 흑
				int count = findRemove(); // 제거된개수?
				if (max < count)
					max = count;
				modiMap(pair1, pair2);
			}
		}
		System.out.println(max);

	}

	public static void print(boolean[][] aa) {
		System.out.println(";;;;");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(aa[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] deepCopy() {
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		return tempMap;
	}

	public static void print(int[][] aa) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(aa[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int findRemove() {
		// 돌 2개를 바꾼 상태에서, 제거되는 흙돌 찾기
		visited = new boolean[N][M];
		int rs = 0;
		int[][] tempMap = deepCopy();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempMap[i][j] == BLACK && !visited[i][j]) {
					int emptyCnt = 0;
					int tmp = 1;
					Queue<Pair> que = new LinkedList<>();
					que.add(new Pair(i, j));
					visited[i][j] = true;
					while (!que.isEmpty()) {
						Pair now = que.poll();
						visited[now.i][now.j] = true;
						for (int d = 0; d < 4; d++) {
							int nexti = now.i + di[d];
							int nextj = now.j + dj[d];
							if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]) {
								if (tempMap[nexti][nextj] == BLACK) {
									visited[nexti][nextj] = true;
									que.add(new Pair(nexti, nextj));
									tmp++;
									continue;
								}
								if (tempMap[nexti][nextj] == 0) {
									emptyCnt++;
								}
							}
						}
						if (emptyCnt > 0) {
							tempMap[now.i][now.j] = 0;
							tmp = 0;
						}
					}
					rs += tmp;
				}
			}
		}
		return rs;
	}

	public static void modiMap(Pair p1, Pair p2) {
		if (map[p1.i][p1.j] == 0) {
			map[p1.i][p1.j] = WHITE;
			map[p2.i][p2.j] = WHITE;
		} else if (map[p1.i][p1.j] == WHITE) {
			map[p1.i][p1.j] = 0;
			map[p2.i][p2.j] = 0;
		}
	}

	// 내 주변에 검은돌이 있으면 true반환
	public static boolean isPossible(int ni, int nj) {
		boolean flag = false;
		for (int d = 0; d < 4; d++) {
			int nexti = ni + di[d];
			int nextj = nj + dj[d];
			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M) {
				if (map[nexti][nextj] == BLACK && map[ni][nj] == 0) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	static class Pair {
		int i;
		int j;

		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
