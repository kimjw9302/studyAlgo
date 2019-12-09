package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1809_JUNGOL {
	static BufferedReader br;
	static Stack<Building> high;
	static int N;
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder("0").append(" ");
		high = new Stack<>();
		high.push(new Building(0, Integer.parseInt(st.nextToken()))); // 첫번째 값 세팅.

		for (int i = 1; st.hasMoreTokens(); i++) {
			Building p = high.peek(); // 맨위에값 peek
			int h = Integer.parseInt(st.nextToken()); // 입력한 높이 값
			if (p.height < h) {
				while (true) {
					p = high.pop(); // 팝해서 다시비교
					if (p.height >= h) { // 자신보다 큰것 찾았을경우
						high.push(p);
						sb.append(p.index).append(" ");
						break;
					}
					// 벽까지온 경우
					if (high.isEmpty()) {
						sb.append("0").append(" ");
						break;
					}
				}
			}  else {
				sb.append(p.index).append(" ");
			}
			high.push(new Building(i, h));
		}
		System.out.println(sb);
	}
}

class Building {
	int index;
	int height;

	Building(int index, int height) {
		this.index = index + 1;
		this.height = height;
	}
}
