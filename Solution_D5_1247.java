package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247 {
	static int TC, N;
	static int[] arr_i; // i좌표
	static int[] arr_j; // j좌표
	static int starti, startj, endi, endj;
	static boolean[] used;
	static int answer,min,minindex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 좌표 초기화
			min = Integer.MAX_VALUE;
			minindex = 0;
			starti = Integer.parseInt(st.nextToken());
			startj = Integer.parseInt(st.nextToken());
			endi = Integer.parseInt(st.nextToken());
			endj = Integer.parseInt(st.nextToken());
			arr_i = new int[N+2];
			arr_j = new int[N+2];
			used = new boolean[N+2];
			answer = Integer.MAX_VALUE;
			for (int i = 1; st.hasMoreTokens(); i++) {
				arr_i[i] = Integer.parseInt(st.nextToken());
				arr_j[i] = Integer.parseInt(st.nextToken());
			}
			arr_i[0] = starti;
			arr_j[0] = startj;
			arr_j[N+1] = endi;
			arr_j[N+1] = endj;
			solution(0,0,0);

			System.out.println("#"+tc+ " "+min);
		}
	}
	
	private static void solution(int index,int count,int sum) {
		if(sum >min) return;
		if(count == N) {
			int k = Math.abs(arr_i[index] -endi) + Math.abs(arr_j[index]-endj);
			sum+=k;
			if(min>sum) {
				min = sum;
				minindex = index;
			}
			return;
		}
		if(used[index]) return;
		for(int i = 0 ; i < N+1 ; i++) {
			if(index == i || used[i]) continue;
			used[index] = true;
			int k = Math.abs(arr_i[index] -arr_i[i]) + Math.abs(arr_j[index]- arr_j[i]);
			solution(i,count+1,sum+k);
			used[index] = false;
		}
	}
}
