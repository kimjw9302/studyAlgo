package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2458 {
	static int N, M;
	static char[][] graph;
	static boolean[] visited;
	static int answer;
	static int taller, smaller;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N+1];
		graph = new char[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ni = Integer.parseInt(st.nextToken());
			int nj = Integer.parseInt(st.nextToken());
			graph[ni][nj] = 'S';
			graph[nj][ni] = 'T';
		}

		for (int i = 1; i <= N; i++) {
			taller = 0;
			visited = new boolean[N + 1];
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 'S') {
					dfs(i, j, 'S');
				}
			}
			result[i] = taller;
		}
		
		for (int i = 1; i <= N; i++) {
			taller = 0;
			visited = new boolean[N + 1];
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 'T') {
					dfs(i, j, 'T');
				}
			}
			result[i] +=taller;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			if(result[i] == N-1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int ni, int nj, char c) {
		if (visited[nj]) {
			return;
		}
		taller++;
		visited[nj] = true;
		for (int i = 1; i <= N; i++) {
			if (graph[nj][i] == c && ni != i) {
				dfs(nj, i, c);
			}
		}
	}
}