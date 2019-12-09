package algo.study;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_오목 {
	static int[][] map = new int[19][19];
	static boolean[][][] visited = new boolean[19][19][4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int d = 0; d < 4; d++) {
			for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 19; j++) {
					if (map[i][j] != 0 && !visited[i][j][d]) {
						if (go(i, j, d, 1, map[i][j])) {
							System.exit(0);
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	// -> 오른대각아래, 아래,왼대각아래;
	public static boolean go(int ni, int nj, int dir, int count, int color) {
		int[] di = { 0, 1, 1, 1 };
		int[] dj = { 1, 1, 0, -1 };
		int nexti = ni + di[dir];
		int nextj = nj + dj[dir];
		if (visited[ni][nj][dir])
			return false;
		int cnt = count;
		ArrayList<Integer> addX = new ArrayList<>();
		ArrayList<Integer> addY = new ArrayList<>();
		addX.add(ni);
		addY.add(nj);
		while (true) {
			if (nexti >= 0 && nexti < 19 && nextj >= 0 && nextj < 19 && !visited[nexti][nextj][dir]
					&& color == map[nexti][nextj]) {
				visited[nexti][nextj][dir] = true;
				addY.add(nextj);
				addX.add(nexti);
				nexti += di[dir];
				nextj += dj[dir];
				cnt++;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			if (dir == 3) {
				System.out.println(map[ni][nj]);
				System.out.println((addX.get(4) + 1) + " " + (addY.get(4) + 1));
			} else {
				System.out.println(map[ni][nj]);
				System.out.println((addX.get(0) + 1) + " " + (addY.get(0) + 1));
			}
			return true;
		} else {
			return false;
		}
	}
}