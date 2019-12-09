package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458 {
	static long  supervisor, assitant;
	static int N;
	static long[] applicant;
	static long[] memoization;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		memoization = new long[1000001];
		applicant = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			applicant[i] = Integer.parseInt(st.nextToken());
		} // for
		long answer = N;

		st = new StringTokenizer(br.readLine());
		supervisor = Integer.parseInt(st.nextToken());
		assitant = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int now = (int) ((applicant[i] - supervisor) < 0 ? 0 : applicant[i] - supervisor);
			if (memoization[now] != 0) {
				answer += memoization[now];
			} else {
				long namage = now % assitant;
				long mok = now / assitant;
				if (namage == 0) {
					answer += mok;
				} else {
					mok = mok +1;
					answer += mok;
				}
				memoization[now] = mok;
			}
		} // for
		System.out.println(answer);
	}
}
