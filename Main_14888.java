/*  2019. 9. 2.
    Main_14888.java
    student     */

package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14888 {
	static int N;
	static int[] num;
	static boolean[] visit;
	static LinkedList<Character> ops;
	static long max,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ops = new LinkedList<>();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		max = Long.MAX_VALUE;
		min = Long.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int opCnt = Integer.parseInt(st.nextToken());
			char input = '+';
			switch (i) {
			case 0:
				input = '+';
				break;
			case 1:
				input = '-';
				break;
			case 2:
				input = '*';
				break;
			case 3:
				input = '/';
				break;
			}
			for (int j = 0; j < opCnt; j++) {
				ops.add(input);
			}

		}
		visit = new boolean[ops.size()];
		dfs(0, 0, num[0]);
		System.out.println(max);
		System.out.println(min);

	}

	public static long cal(long a, char op, long b) {
		long res = 0;
		switch (op) {
		case '+':
			res = a + b;
			break;
		case '-':
			res = a - b;
			break;
		case '*':
			res = a * b;
			break;
		case '/':
			res = a / b;
			break;
		}
		return res;
	}

	public static void dfs(int num_idx, int visit_idx, long result) {
		if (num_idx == N - 1) {
			if(max <result) {
				max = result;
			}
			if(min>result) {
				min = result;
			}
			if(max==Long.MAX_VALUE) {
				max = min;
			}else if(min ==Long.MAX_VALUE) {
				min = max;
			}
			return;
		}

		for (int i = 0; i < ops.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(num_idx + 1, i, cal(result, ops.get(i), num[num_idx + 1]));
				visit[i] = false;
			}
		}
	}
}
