package algo.study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_D4_7465 {
	static int TC,N,M;
	static int[] disjoint;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for(int tc = 1 ; tc<=TC;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			disjoint = new int[N+1];
			
			for(int i = 1 ; i <= N ;i++) {
				disjoint[i] = i;
			}
			for(int m = 0 ; m <M ;m++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if(find(n1) != find(n2)) {
					union(n1,n2);
				}
			}
			Set<Integer> set = new HashSet<>();
			for(int i = 1 ; i<=N;i++) {
				set.add(find(disjoint[i]));
			}
			System.out.println("#"+tc+" "+set.size());
		}
	}
	public static int find(int idx) {
		if(disjoint[idx] == idx) {
			return idx;
		}
		disjoint[idx] = find(disjoint[idx]);
		return disjoint[idx];
	}
	public static void union(int n1,int n2) {
		int p1 = find(disjoint[n1]);
		int p2 = find(disjoint[n2]);
		if(p1!=p2) {
			disjoint[p1] = p2;
		}
	}
}
