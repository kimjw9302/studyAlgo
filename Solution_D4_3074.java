package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3074 {
	static int TC, N, M;
	static int[] times;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 카운터수
			M = Integer.parseInt(st.nextToken()); // 사람수
			times = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				times[i] = Integer.parseInt(br.readLine());
				max = Math.max(max, times[i]); //심사대기준으로 최대 시간 찾기.
			}
			
			long left = 1;
			long right = max*(long)M;
			long total = 0;
			long mid = 0;
			while(left <= right) {
				  mid=(left+right)/2;
	                total=0;
	                for(int k=0;k<N;k++)
	                    total+=mid/times[k];
	                if(total<M)
	                    left=mid+1;
	                else
	                    right=mid-1;
			}
			System.out.println("#"+tc+" " +left);
		}

	}


}
