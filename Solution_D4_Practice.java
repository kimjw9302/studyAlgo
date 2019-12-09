package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_Practice {
	static int TC, N;
	static int[][] map;
	static LinkedList<Core> cores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			for(int i  = 0 ; i < N ;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; st.hasMoreTokens();j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 || i == N-1 || j==0||j == N-1) {
						continue;
					}
					if(map[i][j] ==1) cores.add(new Core(i,j));
				}
			}
			for(int i = 0 ; i< cores.size(); i++) {
				Core c = cores.get(i);
				
			}
		}
	}
	static  public void checkCount() {
		for(int i = 0 ;i ) {
			
		}
	}
	static public class Core{
		int i,j;
		boolean conn;
		Core(int i , int j){
			this.i = i;
			this.j = j;
		}
	}
}
