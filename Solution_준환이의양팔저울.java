package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_준환이의양팔저울 {
	static int TC, N;
	static int[] choo;
	static boolean[] used;
	static int answer;
	static int sum;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			choo = new int[N];
			used = new boolean[N];
			arr = new int[N];
			answer = sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
				sum += choo[i];
			}
			for (int i = 0; i < N; i++) {
				arr[0] = choo[i];
				used[i] = true;
				permu(1, 1, N,choo[i]);
				used[i] = false;
			}

			System.out.println("#" + tc + " " + answer);
		}

	}

	private static void permu(int idx, int cnt, int r,int leftSum) {
		if (cnt == r) {
			int left = 0;
			for(int i = 0 ;i <N;i++) {
				left+=arr[i];
			}
			int right = sum - left;
			if (left >= right) {
				System.out.println(Arrays.toString(arr));
				System.out.println("=========");
				answer++;
			}
			return;
		}
		if (idx >= N)
			return;
		// 쓰거나, 쓰지않는다(여러개);
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[idx] = choo[i];
				permu(idx + 1, cnt + 1, r,leftSum+choo[i]);
				arr[idx] = 0;
				used[i] = false;
			}
		}
		if(leftSum>=choo[idx]) {
			arr[idx] = 0;
			permu(idx + 1, cnt + 1, r,leftSum);
		}
	}
}
