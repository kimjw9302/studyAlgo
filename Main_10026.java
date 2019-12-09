package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {
	static int N; // 배열 수
	static char[][] normal;
	static char[][] blind;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		normal = new char[N][N];
		blind = new char[N][N];
		// 색깔 정보 입력 받기
	
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char chr = line.charAt(j);
				switch (chr) {
				case 'R':
					normal[i][j] = chr;
					blind[i][j] = chr;
					break;
				case 'G':
					normal[i][j] = chr;
					blind[i][j] = 'R';
					break;
				case 'B':
					normal[i][j] = chr;
					blind[i][j] = chr;
					break;
				}
			}
		}
//		print(normal);
//		System.out.println("---");
//		print(blind);
		int normalCount = 0;
		int blindCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (normal[i][j] != '0') {
					dfs(i, j, normal,normal[i][j]);
					normalCount++;
				}
				
				if(blind[i][j] != '0') {
					dfs(i,j,blind,blind[i][j]);
					blindCount++;
				}
			}
		}
		System.out.println(normalCount + " "+blindCount);

	}

	public static void print(char[][] arr) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void dfs(int i, int j, char[][] arr,char color) {
		// 종료조건 (4방향을 탐색했는데 갈 곳이 없다)
		// 컬러 확인.
		
		arr[i][j] = '0';

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];
			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N) { // 다음 방문할 좌표가 NxN 좌표 안에 있다면,
				if (arr[nexti][nextj] == color && arr[nexti][nextj] != '0') { // 같은 색이고, 방문한적이 없다면,
//					System.out.println(nexti + " // " +nextj +"// " +color +"// " +arr[nexti][nextj]);
					dfs(nexti, nextj, arr,color);
				}
			}
		}

	}
}
