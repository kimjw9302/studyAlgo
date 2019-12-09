package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1244 {
	static int TC;
	static char[] num;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			num = st.nextToken().toCharArray(); // 123
			int cnt = Integer.parseInt(st.nextToken()); // 1
			answer = 0;
			visited = new boolean[1000001];
			permutation(cnt); 
			System.out.println("#" + tc + " " + answer);
		}

	}

	private static void permutation(int n) {
		if (n == 0) {
			String str = new String(num);
			if (answer < new Integer(str).intValue()) {
				answer = new Integer(str).intValue();
			}
			System.out.println(str);
			return;
		}
		if (visited[new Integer(new String(num)).intValue()]) {
			return;
		}
		visited[new Integer(new String(num)).intValue()] = true;
		
		for (int i = 0; i < num.length; i++) {
			for (int j = i+ 1; j < num.length; j++) {
				swap(j, i);
				permutation(n - 1);
				swap(j, i);

			}
		}
	}

	public static void swap(int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
