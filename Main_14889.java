package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14889 {
	static int N;
	static int[][] startlink;
	static int answer = Integer.MAX_VALUE;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		startlink = new int[N][N];
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				startlink[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(answer);
	}

	public static void dfs(int index,int count) {
		//종료조건
		if(count == N/2) {
			int start = 0;
			int link = 0;
			boolean[] startcheck = new boolean[N];
			boolean[] linkcheck = new boolean[N];
			for(int i = 0 ; i < N; i++) {
				if(used[i]) {
					used[i] = false;  //1 
					startcheck[i] = true;
					for(int j = 0 ; j < N ; j++) {
						if(used[j]) {
//							System.out.println("start!  "+ i +","+j);
							start += startlink[i][j];
						}
					}
					used[i] = true;
				}else {
					used[i] = true;  //1 
					linkcheck[i] = true;
					for(int j = 0 ; j < N ; j++) {
						if(!used[j]) {
//							System.out.println("link!  "+ i +","+j);
							link += startlink[i][j];
						}
					}
					used[i] = false;
				}
			}
//			System.out.println( Math.abs(start - link));
			answer = Math.min(answer, Math.abs(start - link));
			return;
		}
		if(index == N) {
			return;
		}
		used[index] = true;
		dfs(index+1,++count);
		used[index] = false;
		dfs(index+1,--count);
	}
}
