package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_2806 {
	static int TC; // 테케
	static int N, answer;
	static int[] queen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			queen = new int[N + 1];
			answer = 0;
			dfs(1);
			System.out.println("#" + tc + " " + answer);
//			System.out.println(Arrays.toString(queen));
		}
	}

	public static boolean isPossible(int i) {
//		System.out.println(Arrays.toString(queen));
		if (i == 1)
			return true;

		for (int k = 1; k < i; k++) {
			if (queen[k] == queen[i]) { // 같은 열
//				System.out.println(queen[k] + " ,, " + queen[i] + " 같은 열에 존재");
				return false;
			}
			if (Math.abs(queen[k] - queen[i]) == Math.abs(k - i)) {
//				System.out.println("("+i+","+j+") / " + "("+k + ","+queen[k]+")");
//				System.out.println("같은 대각선?");
				return false;
			}
		}
		return true;
	}

	public static void dfs(int i) {
		if (i == N +1) {
//			System.out.println(" 종료  : "+Arrays.toString(queen));
			answer++;
			return;
		}
//		System.out.println(i);
		for (int j = 1; j <= N; j++) {
			queen[i] = j;
			if (isPossible(i)) { // 가능한지 체크?
				dfs(i + 1);
			}
		}
	}
}
