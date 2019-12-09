package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15686 {
	static int N, M;
	static LinkedList<Node> house = new LinkedList<>();
	static LinkedList<Node> chicken = new LinkedList<>();
	static boolean[] used;
	static int count;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 크기
		M = Integer.parseInt(st.nextToken()); // 필요한 치킨집 개수
		// 치킨집 리스트와 집 리스트 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				String str = st.nextToken();
				if (str.equals("2")) {
					chicken.add(new Node(i, j));
				} else if (str.equals("1")) {
					house.add(new Node(i, j));
				}
			}
		}
		count =  0;
		result = Integer.MAX_VALUE;
		used = new boolean[chicken.size()];
		// 치킨집을 토대로 조합을 찾아야함.
		dfs(0, 0);
		System.out.println(result);
	}

	static public void dfs(int index, int count) {
		// 종료조건, 치킨집과 카운트가 같아지면
		if (count == M ) {
			// 로직추가
			int totalDistance = 0;
			for (int i = 0; i < house.size(); i++) {
				Node h = house.get(i);
				int hTOc = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (used[j]) {
						Node c = chicken.get(j);
						int distance = Math.abs(h.i - c.i) + Math.abs(h.j - c.j);
						hTOc = Math.min(distance, hTOc);
					}
				}
				totalDistance+=hTOc;
			}
			result = Math.min(result , totalDistance);
			return;
		}
		if(index == used.length) {
			return;
		}
		used[index] = true;
		dfs(index + 1, ++count);
		used[index] = false;
		dfs(index + 1, --count);

	}

	static public class Node {
		int i, j;

		Node(int i, int j) {
			this.i = i + 1;
			this.j = j + 1;
		}
	}
}
