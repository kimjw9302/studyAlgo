package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263 {
	static int TC, N;
	static int[][] edge; // 간선 연결 정보
	static final int INF = 999;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			edge = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 0) {
						edge[i][j] = INF;
					} else {
						edge[i][j] = input;
					}
//					System.out.print(edge[i][j] + " ");
				}
//				System.out.println(" ");
			}
			// 플로이드 와샬
			for (int k = 1; k < N + 1; k++) {
				for (int i = 1; i < N + 1; i++) {
					if (i != k) {
						for (int j = 1; j < N + 1; j++) {
							if (i != j && j != k) {
									edge[i][j] = Math.min(edge[i][k] + edge[k][j], edge[i][j]);
							}
						}
					}
				}

			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < N + 1; i++) {
				min = Math.min(min, sum(edge[i],i));
			}
			System.out.println("#" + tc + " " + min);
//			print(edge);
		}

	}

	private static int sum(int[] aa ,int idx) {
		int num = 0;
		for (int i = 1; i < N + 1; i++) {
			if (aa[i] == INF || i== idx) {
				continue;
			} else {
				num += aa[i];
			}
		}
		return num;
	}

	private static void print(int[][] aa) {
		System.out.println("Print call===");
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(aa[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}
