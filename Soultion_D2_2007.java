package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Soultion_D2_2007 {
	public static int TC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String line = br.readLine();
			// 30문자열, 마디는 최대 10
			int width = 10;
			boolean end = false;
			String answer = "";
			for (int i = 0; i < 10; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(line.substring(0, 10 - i));
				for (int j = sb.length(); j < line.length() - width; j++) {
					if (sb.toString().equals(line.substring(j, j + width - i))) {
						answer = sb.toString();
						end = true;
						break;
					} else {
						break;
					}
				}
				if (end) {
					break;
				}
			}
			// 다시 체킹 패턴이므로 될경우 짝수,홀수
			if ((answer.length() % 2 == 0) && (answer.substring(0, answer.length() / 2)
					.equals(answer.substring(answer.length() / 2, answer.length())))) {
				answer = answer.substring(0, answer.length()/2);
			}
			if ((answer.length() % 3 == 0) && (answer.substring(0, 3).equals(answer.substring(3, 6)))) {
				answer = answer.substring(0, 3);
			}
			//5로 나눴는데도 같은경우가 있다는건 1인경우밖에없음
			if (answer.length() == 5) {
				char[] ch = new char[5];
				for (int i = 0; i < 5; i++) {
					ch[i] = answer.charAt(0);
				}
				String st = new String(ch);
				if(st.equals(answer)) {
					answer = ""+answer.charAt(0);
				}
			}
			System.out.println("#" + tc + " " + answer.length());
		}
	}
}
