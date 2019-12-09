package algo.study;

import java.util.Scanner;

public class Main_Jungol_1863 {
	static int[] stu;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		stu = new int[N + 1];
		int[] check = new int[N+1]; 
		for (int i = 1; i <= N; i++) {
			stu[i] = i;//무의미한대표선정
		}
		for (int m = 0; m < M; m++) {
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			if(s1>s2) {
				int tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
			if(find(s1)!=find(s2)) {
				union(s1,s2);
			}
		}
		for(int i = 1 ; i<=N;i++) {
			check[find(stu[i])]++;
		}
		int answer = 0;
		for(int i = 1 ; i<=N;i++) {
			if(check[i]>=1) answer++;
		}
		System.out.println(answer);
	}
	public static int find(int s1) {
		if(stu[s1] == s1) {
			return s1;
		}
		int p = find(stu[s1]);
		stu[s1] = p;
		return p;
	}
	public static void union(int s1,int s2) {
		int p1 = find(s1);
		int p2 = find(s2);
		if(p1!=p2) {
			stu[p2] = p1;
		}
	}
}
