package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] secrets = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][M];
			String secret = "";
			for(int i = 0 ; i < N; i++) {
				line = br.readLine();
				if(line.contains("1")) {
					secret = line;
				}
			}
			ArrayList<Integer> answer = new ArrayList<>();
			int cnt = 0;
			while(secret.length() != 0) {
				boolean flag = false;
				for(int i = 0 ; i < secrets.length; i++) {			
					if(secret.endsWith(secrets[i])) {
//						System.out.println(i + " // " +secrets[i]);
						answer.add(i);
						secret= secret.substring(0,secret.length()-7);
						flag = true;
						break;						
					}
				}
				
				if(!flag) {
					secret= secret.substring(0,secret.length()-1);
				}
				
//				System.out.println(secret);
				
			}
//			System.out.println(answer);
			int sum = 0;
			sum = (answer.get(7)+answer.get(5)+answer.get(3)+answer.get(1))*3 + answer.get(0)+ answer.get(2)+answer.get(4)+answer.get(6);
//			System.out.println(sum);
			if(sum%10 == 0) {
				sum=0;
				for(int k = 0 ; k<answer.size();k++) {
					sum+=answer.get(k);
				}
				System.out.println("#"+tc +" "+sum);
			}else {
				System.out.println("#"+tc +" 0");
			}
			//(홀수 자리 합 * 3) + 짝수자리합+ 검증코드
		}
	}
}
