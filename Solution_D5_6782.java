package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D5_6782 {
	static int TC;
	static double N;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Double.parseDouble(br.readLine());
			count = 0;
			dfs(N); // 20
			System.out.println("#" + tc + " " + count);
		}
	}

	public static void dfs(double nn2) {
		if (nn2 == 2.0) {
			return;
		}
		double nn = Math.sqrt(nn2); // 9.24324
		count++;
		double d = Math.ceil(nn); // 10
		count += (d * d) - N; // 100-99
		N = d; // N =10
		if (d == 2) {
			return;
		}
		dfs(d);

	}
}
