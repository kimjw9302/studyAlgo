package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1213 {
	static final int CASE = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= CASE; tc++) {

			int T = Integer.parseInt(br.readLine());
			int answer = 0;
			char[] word = br.readLine().toCharArray();
			char[] line = br.readLine().toCharArray();
			int n = 0;
			for (int i = 0; i < line.length; i++) {
				
				if(line[i] == word[n]) {
					n++;
				}else {
					if(n!=1) {
						
					}
					
				}
				if(n == word.length) {
					System.out.println(i);
					n = 0;
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
