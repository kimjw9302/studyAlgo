package algo.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_8382 {
	static int TC;
	static int[] di = { 0, 0, 1, -1 }; //세로, 가로..? 문제에서 원하는..
	static int[] dj = { 1, -1, 0, 0 };
	static int[] values = new int[201];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int ci = sc.nextInt();
			int cj = sc.nextInt();
			int ni = sc.nextInt();
			int nj = sc.nextInt();
			
			int x = Math.abs(ci - ni);
			int y = Math.abs(cj - nj);
			if(y>x) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			
			//첫째항  ( 0,1,4,5,8,9,12,13,16,17,20,21...)
					// 짝수 : 0,4,8,12,16...
					// 홀수 : 1,5,9,13,17...
			int firstd = x-y;
			int fd = 0;
//			System.out.println(firstd);
			if(firstd%2==0) {//짝수항 등차 4(n-4
				fd = 4*(firstd/2+1) -4 ;
			}else {//홀수항 등차 4n-3
				fd = 4*(firstd/2+1) -3;
			}
//			System.out.println(fd);
			//두번째항 (첫째항+2..)
			int answer  = 0;
			
			answer = fd + 2*(y);
			
			System.out.println("#"+tc+ " "+answer);

		}
	}

}
