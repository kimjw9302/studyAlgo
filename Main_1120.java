package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] ch1 = st.nextToken().toCharArray();
		char[] ch2 = st.nextToken().toCharArray();
		int len = ch2.length - ch1.length;
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i <= len ;i++) {
			int count = 0;
			for(int j = 0 ; j < ch1.length;j++) {
				if(ch1[j] != ch2[j+i]) {
					count++;
				}
			}
			if(min>count) {
				min = count;
			}
		}
		System.out.println(min);
	}
}

