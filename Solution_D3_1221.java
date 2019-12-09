package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_D3_1221 {
	static int T, N;
	static String TC;
	static int[] arr;
	static Map<Integer,String> map= new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			TC = st.nextToken(); // #1
			N = Integer.parseInt(st.nextToken()); // 7041
			arr = new int[10];
			st = new StringTokenizer(br.readLine(), " "); // SVN FOR ZRO
			StringBuilder sb = new StringBuilder(TC).append("\n");
			for (;st.hasMoreTokens();) {
				String word = st.nextToken();
				if (word.equals("ZRO")) {					
					arr[0]++;
				}
				else if (word.equals("ONE")) {
					arr[1]++;
				}
				else if (word.equals("TWO")) {
					arr[2]++;
				}
				else if (word.equals("THR")) {
					arr[3]++;
				}
				else if (word.equals("FOR")) {
					arr[4]++;
				}
				else if (word.equals("FIV") ) {
					arr[5]++;
				}
				else if (word.equals("SIX")) {
					arr[6]++;
					continue;
				}
				else if (word.equals("SVN")) {
					arr[7]++;
				}
				else if (word.equals("EGT")) {
					arr[8]++;
				}
				else if (word.equals("NIN")) {
					arr[9]++;
				}
			}
			map.put(0,"ZRO");
			map.put(1,"ONE");
			map.put(2,"TWO");
			map.put(3,"THR");
			map.put(4,"FOR");
			map.put(5,"FIV");
			map.put(6,"SIX");
			map.put(7,"SVN");
			map.put(8,"EGT");
			map.put(9,"NIN");
			for(int i = 0 ; i < 10 ; i++) {
				for(int j = 0 ;j <arr[i]; j++) {
					sb.append(map.get(i)).append(" ");
				}			
			}
			
			System.out.println(sb);
		}

	}
}
