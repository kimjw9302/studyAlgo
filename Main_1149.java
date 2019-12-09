package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
	static int N;
	static int[][] dp;
	static int[][] arr;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][3];
		arr = new int[N + 2][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0] = arr[1];
		for (int i = 1; i <= N; i++) {
			
			for (int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (j != k) {
						if (min > dp[i - 1][k]) {
							min = dp[i - 1][k];
						}
					}
				}
				dp[i][j] = arr[i+1][j] + min;
			}
		}
		answer = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3 ; i++) {
			if(answer > dp[N-1][i]) {
				answer = dp[N-1][i];
			}
		}
		System.out.println(answer);
	}
}
