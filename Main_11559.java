package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559 {
	static char[][] game;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		game = new char[12][6];
		for (int i = 0; i < 12; i++) {
			game[i] = br.readLine().toCharArray();
		}
		mapArrange(); // 중력으로 땡기기><
		Queue<Pos> que = new LinkedList<>();
		ArrayList<Pos> pangList = new ArrayList<>();
		boolean[][] visited = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				if (game[i][j] != ' ') {
					que.add(new Pos(i, j));
					int count = 0;
					visited[i][j] = true;
					char color = game[i][j];
					while (!que.isEmpty()) {
						Pos now = que.poll();
						System.out.println(color);
						for (int d = 0; d < 4; d++) {
							int nexti = now.i + di[d];
							int nextj = now.j + dj[d];
							if (nexti >= 0 && nexti < 12 && nextj >= 0 && nextj < 6 && game[nexti][nextj] != ' ') {
								if(!visited[nexti][nextj] && color == game[nexti][nextj]) {
									visited[nexti][nextj] = true;
									que.add(new Pos(nexti,nextj));
									pangList.add(new Pos(nexti,nextj));
								}
							}
							System.out.println(pangList.size());
						}
					}
					if(pangList.size()>=4) {
						for(int k = 0 ; k<pangList.size();k++) {
							game[pangList.get(i).i][pangList.get(j).j] = ' ';
						}
					}
				}
			}
		}
		print(game);
	}

	public static void print(char[][] aa) {
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa[0].length; j++) {
				System.out.print(aa[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void mapArrange() {
		char[][] gameTmp = new char[12][6];
		for (int j = 0; j < 6; j++) {
			int idx_I = 11;
			for (int i = 11; i >= 0; i--) {
				if (game[i][j] != '.') {
					gameTmp[idx_I--][j] = game[i][j];
				}
			}
			for (int i = 11; i >= 0; i--) {
				if (game[i][j] != 'R'||game[i][j] != 'Y'||game[i][j] != 'G') {
					gameTmp[i][j] = '.';
				}
			}
		}
		game = gameTmp;
	}

	static class Pos {
		int i, j;

		Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
