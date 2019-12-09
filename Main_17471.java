package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 게리멘더링(SW expert 시험 1번)
 */
public class Main_17471 {
	static int N;
	static int[] ingu;
	static boolean[] used;
	static boolean[][] conn;
	static ArrayList<Integer> group1;
	static ArrayList<Integer> group2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ingu = new int[N];
		conn = new boolean[N][N];
		used = new boolean[N];
		group1 = new ArrayList<>();
		group2 = new ArrayList<>();
		for (int i = 0; st.hasMoreTokens(); i++)
			ingu[i] = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; st.hasMoreTokens();j++) {
				conn[i][j] = true;
			}
			
		}
		
		int mid = N % 2 == 0 ? N / 2 + 1 : N / 2;
		for (int i = 1; i < mid; i++) {
			subSet(i, 0, 0);
		}
	}

	public static void subSet(int limit, int cnt, int idx) {
		if (idx == N)
			return;
		if (cnt == limit) {
			group1.clear();
			group2.clear();
			for (int i = 0; i < N; i++) {
				if (used[i]) {
					group1.add(i);
				}else {
					group2.add(i);
				}
			}
			boolean conn_1 = false;
			if(group1.size() == 1) {
				conn_1 = true;
			}else {
				for(int k = 0 ; k < group1.size();k++) {
					for(int j = 0 ; j < N ; j++) {
						if(conn[group1.get(k)][j]) {
							group1.
						}
					}
				}
			}
			boolean conn_2 = false;
			
			System.out.println("group1 : "+group1);
			System.out.println("group2 : "+group2);
			
			
			
			return;
		}
		used[idx] = true;
		subSet(limit, cnt + 1, idx + 1);
		used[idx] = false;
		subSet(limit, cnt, idx + 1);
	}
}
