package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699 {
	static int TC, R, C;
	static char[][] citys;
	static int[] alphabets;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			answer = 0;
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			citys = new char[R][C];
			// 'A' = 65;
			alphabets = new int['Z' - 'A' + 1];
			for (int i = 0; i < R; i++) {
				citys[i] = br.readLine().toCharArray();
			}
			dfs(0, 0, 1);
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void dfs(int i, int j, int count) {
		if(answer == 26) return; //시간단축을 위한 종료 조건 개꿀?//
		if (answer <= count) {
			answer = count;
		}
		char now = citys[i][j];
		alphabets[now - 'A'] = 1;
		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];
			if (nexti >= 0 && nexti < R && nextj >= 0 && nextj < C) { // 유효범위안에 존재한다면,
				char nextAlph = citys[nexti][nextj];
				if (alphabets[nextAlph - 'A'] == 0) { // 방문하지 않았던 곳이면,
					alphabets[nextAlph - 'A'] = 1;
					dfs(nexti, nextj, count+1);
					alphabets[nextAlph - 'A'] = 0;
				}
			}
		}
		return;
	}
}
