package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583 {
	static boolean[][] map;
	static int M, N, K;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Point> queue = new LinkedList<>();
		LinkedList<Integer> answer = new LinkedList<>();
		M = Integer.parseInt(st.nextToken()); // 5
		N = Integer.parseInt(st.nextToken()); // 7
		K = Integer.parseInt(st.nextToken()); // 3
		map = new boolean[M][N];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int j1 = Integer.parseInt(st.nextToken());
			int i1 = Integer.parseInt(st.nextToken());

			int j2 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
	
			for (int i = i1; i < i2; i++) {
				for (int j = j1; j < j2; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j]) {
					//bfs
					queue.add(new Point(i, j));
					int cnt = 1;
					map[i][j] = true;
					while(!queue.isEmpty()){
						Point p = queue.poll();
						for(int d = 0 ; d < 4 ; d++) {
							int nextI = p.i + di[d];
							int nextJ = p.j + dj[d];
							if(nextI>=0 && nextI<M && nextJ>=0 && nextJ<N && !map[nextI][nextJ]) {
								queue.add(new Point(nextI,nextJ));
								map[nextI][nextJ] = true;
								cnt++;
							}
						}
					}
					answer.add(cnt);
				}
			}
		}
		answer.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.intValue() < o2.intValue()) {
					return -1;
				}
				return 0;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (Integer integer : answer) {
			sb.append(integer).append(" ");
		}
		System.out.println(answer.size());
		System.out.println(sb.toString());
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
