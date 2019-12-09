package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1226 {
	static BufferedReader br;
	static final int TC = 10;
	static int[][] map = new int[16][16];
	static final int EXIT = 3;
	static final int START = 2;
	static final int WALL = 1;
	static final int EMPTY = 0;
	static Queue<Point> que;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= TC; tc++) {
			int T = Integer.parseInt(br.readLine());
			que = new LinkedList<Point>();
			for (int i = 0; i < 16; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					int num = c[j] - '0';
					if (num == START) {
						que.add(new Point(i, j));
					}
					map[i][j] = num;
				}
			}
			//로직 구현하기.
			boolean exitFlag = false;
			while(!que.isEmpty()) {
				Point np = que.poll();
				for(int d = 0 ; d < 4 ; d++) {
					int nextI = np.i + di[d];
					int nextJ = np.j + dj[d];
					if(map[nextI][nextJ] == EMPTY) {
						map[nextI][nextJ] = WALL;
						que.add(new Point(nextI,nextJ));
					}
					if(map[nextI][nextJ] == EXIT) {
						exitFlag = true;
						break;
					}
				}
			}
			System.out.println("#"+tc+ " " +(exitFlag?1:0));
		}
	}
}

class Point {
	int i, j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
