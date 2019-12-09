package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7532 {
	static int s, e, m, N, TC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
//			System.out.println((175944/365)+ " // "+(175944%365));
//			System.out.println((175944/29)+ " // "+(175944%29));
//			System.out.println((175944/25)+ " // "+(175944%24));
			if (s == e && e == m) {
				System.out.println("#" + tc + " " + s);
				continue;
			}
			int number = 24+e; //3
			if(e == 24) {
				e = 0;
			}
			if(s == 365) {
				s = 0;
			}
			if(m == 29) {
				m = 0;
			}
			while (true) {
				if(number%24 == e) {
					if(number%29 == m) {
						if(number%365==s) {
							System.out.println("#"+tc+" " +number);
							break;
						}
					}
				}
				number+=24;
				
			}
		}
	}
}
