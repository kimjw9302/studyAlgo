package algo.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1209 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1 ; tc<=10 ;tc++ ) {
			//행우선탐색
			int row = rowSum();
			int col = colSum();
			int diagonal = diagonalSum();
			int reversedigonal = reversediagonalSum();
			int max = (row> col)? row:col;
			max = (max > diagonal) ? max : diagonal;
			max = (max > reversedigonal) ? max : reversedigonal;
			
			System.out.println("#"+tc+ " " + max);
			//열우선탐색
			//0,0 ->N,N 우선탐색
			//0,N ->N,0 우선탐색
		}
	}
	public static void rowSum() {
		int max = 0;
		
	}
	public static void colSum() {}
	public static void diagonalSum() {}
	public static void reversediagonalSum() {}
}
