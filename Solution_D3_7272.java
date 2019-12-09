package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_D3_7272 {
	static BufferedReader br;
	static int T;
	static HashMap<Character, Character> map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		settingMap();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] ch1 = st.nextToken().toCharArray();
			String str1 = makeStr(ch1);
			char[] ch2 = st.nextToken().toCharArray();
			String str2 = makeStr(ch2);
			
			if(str1.equals(str2)) {
				System.out.println("#"+tc+" SAME");
			}else {
				System.out.println("#"+tc+" DIFF");
			}
		}
	}
	public static String makeStr(char[] ch1) {
		StringBuilder sb1 = new StringBuilder();
		for(int i = 0 ; i < ch1.length; i++) {
			char c = ch1[i];
			if(map.containsKey(c)) {
				sb1.append(map.get(c));
			}else {
				sb1.append('C');
			}
		}
		return sb1.toString();
	}
	public static void settingMap() {
		map = new HashMap<>();

		map.put('A', 'A');
		map.put('D', 'A');
		map.put('O', 'A');
		map.put('P', 'A');
		map.put('Q', 'A');
		map.put('R', 'A');
		map.put('B', 'B');
	}
}
