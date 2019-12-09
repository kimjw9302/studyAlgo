package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1808 {
	static int TC;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp = new int[1000001];
			for (int n = 0; n <= 9; n++) {
				dp[n] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			if (check(N)) {
				dp[N] = new Integer(N).toString().length();
			} else {
				for (int n = 10; n <= N; n++) {
					if(N%n!=0) {
						continue;
					}
					int min = Integer.MAX_VALUE;
					if (check(n)) {
						dp[n] = (n + "").length();
					} else {
						for (int i = 2; i <= Math.sqrt(n); i++) {
							if (n % i == 0 && dp[n / i] != 0 && dp[i] != 0) {
									min = Math.min(dp[n / i] + dp[i] + 1, min);
							}
						}
						if(min == Integer.MAX_VALUE) {
							dp[n] = 0;
						}else {
							dp[n] = min;
						}
					}
				}
			}
			if(dp[N] == 0) {
				answer = -1;
			}else {
				answer = dp[N]+1;
			}
			System.out.println("#"+tc+" " +answer);
		}

	}

	public static boolean check(int n) {
		char[] ch = (n + "").toCharArray();
		boolean flag = true;
		for (int j = 0; j < ch.length; j++) {
			if (dp[ch[j] - '0'] != 1) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
