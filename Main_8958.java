package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 {
	static int TC;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=TC;tc++) {
			char[] ch = br.readLine().toCharArray();
			int answer = 0;
			for(int i = 0 ; i < ch.length; i++) {
				if(ch[i] == 'O') {
					StringBuilder sb = new StringBuilder().append('O');
					for(int j = i+1 ; j<ch.length; j++) {
						if(ch[j] == 'X') {
//							System.out.println("?"+j);
							break;
						}else { //또 o네
//							System.out.println(j);
							sb.append('O');
						}
					}
//					System.out.println(sb);
					answer+=sb.length();
				}
			}
			System.out.println(answer);
			
		}
	}
}
