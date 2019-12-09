package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4698 {

	static int T, num, start, end;

	static boolean[] prime = new boolean[1000001];
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		makePrime();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int i = start; i <= end; i++) {
				if (prime[i]) {
					for(int j = i ; j > 0 ; j/=10) {
						if(j%10==num) {
							cnt++;
							break;
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder("#").append(tc).append(" ");
			sb.append(cnt);
			System.out.println(sb);

		}

	}

	public static void makePrime() {

		for (int i = 2; i < 1000001; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				prime[i] = true;
			}
		}

	}

	public static boolean isContain(int i) {
		int k = 1;

		return false;
	}

}