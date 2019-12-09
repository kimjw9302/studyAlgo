package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Inte
				ger.parseInt(br.readLine());
		int[][] map = new int[N][N];
		Shark shark = null;
		boolean[][] v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					v[i][j] = true;
					shark = new Shark(i, j);
				}
			}
		}
		int[] dy = { -1, 0, 0, 1 };
		int[] dx = { 0, -1, 1, 0 };
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(shark.y, shark.x, 0));
		int count = 0;
		PriorityQueue<Point> select = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {

				if (o1.y > o2.y) {
					return 1;
				} else if (o1.y == o2.y) {
					if (o1.x > o2.x) {
						return 1;
					} else if (o1.x == o2.x) {
						return 0;
					} else {
						return -1;
					}
				} else {
					return -1;
				}

			}
		});
		int dis = 0;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			if (dis != temp.dis && !select.isEmpty()) {
				Point a = select.poll();
				shark.y = a.y;
				shark.x = a.x;
				shark.count++;
				map[a.y][a.x] = 0;
				count = count + a.dis;
				if (shark.count == shark.size) {
					shark.size++;
					shark.count = 0;
				}
				v = new boolean[N][N];
				select.clear();
				q.clear();
				q.add(new Point(shark.y, shark.x, 0));
				temp = q.poll();
			}
			dis = temp.dis;
			int y = temp.y;
			int x = temp.x;
			for (int i = 0; i < 4; i++) {
				int tempy = y + dy[i];
				int tempx = x + dx[i];
				if (tempy >= 0 && tempy < N && tempx >= 0 && tempx < N && !v[tempy][tempx]) {
					if (shark.size >= map[tempy][tempx]) {
						v[tempy][tempx] = true;
						if (map[tempy][tempx] != 0 && shark.size > map[tempy][tempx]) {
							select.add(new Point(tempy, tempx, temp.dis + 1));
							q.add(new Point(tempy, tempx, temp.dis + 1));
						} else {
							q.add(new Point(tempy, tempx, temp.dis + 1));
						}
					}
				}
			}
		}
		System.out.println(count);
	}

	static class Point {
		int y;
		int x;
		int dis;

		Point(int y, int x, int dis) {
			this.y = y;
			this.x = x;
			this.dis = dis;
		}
	}

	static class Shark {
		int y;
		int x;
		int size;
		int count;

		Shark(int y, int x) {
			this.y = y;
			this.x = x;
			this.size = 2;
			this.count = 0;
		}
	}

}