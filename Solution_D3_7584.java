package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_7584 {

	static int T;
	static long K;
	static StringBuilder sb = new StringBuilder();
	static long c;
	static long middle;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		boolean check = false;
		String arr = "X0010";

		for (int tc = 1; tc <= T; tc++) {

			K = Long.parseLong(br.readLine());

			char answer = '0';
			check = false;
			while (true) {
				int n = 1;
				long d = 0L;// 총갯수
				c = 0L;

				while (true) {
					d = (long) (Math.pow(2, n) - 1);
					if (d >= K) {
						break;
					}
					n++;
				}
				// n번째를 찾음. 중앙값을 찾기위해..
				if (K <= 4) { // 01234567 이면?
					answer = arr.charAt((int) K);
					break;
				}
				// 내위치가 0123에 안들어가...?
				check = !check;
				middle = ((d / 2) % 2 == 0) ?  d / 2 :  d / 2 + 1; // 중앙값찾고
				c = K - middle; // 중앙에서 K까지의 거리
//				System.out.println("d: " + d + ", middle : " + middle + ", K : " + K + " , " + c);

				if (c == 0) {
					answer = '0';
					check = !check;
					break;
				}
				K = middle - c;
			}
			if (check) {
				if (answer == '1') {
					answer = '0';
				} else {
					answer = '1';
				}
			}
//			System.out.println(check);
			System.out.println("#" + tc + " " + answer);

		}

	}

}