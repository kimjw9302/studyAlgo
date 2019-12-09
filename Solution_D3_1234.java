package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1234 {
	static final int TC = 10;
	static List<Integer> num;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String tmp = st.nextToken();
			num = new LinkedList<Integer>();
			for (int i = 0; i < tmp.length(); i++) {
				num.add(tmp.charAt(i) - '0');
			}
			int idx = 1;
			for(int j = 0 ; j < num.size();j++) {
				for (int i = idx; i < num.size(); i++) {
					if (num.get(i - 1) == num.get(i)) {
						num.remove(i - 1);
						num.remove(i - 1);
////						System.out.println(i);
//						idx = i - 1;
//						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder("#").append(tc).append(" ");
			for (Integer i : num) {
				sb.append(i);
			}
			System.out.println(sb.toString());
		}
	}
}
