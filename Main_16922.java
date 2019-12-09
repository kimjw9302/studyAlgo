package algo.study;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_16922 {
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = {1,5,10,50};
		int N = sc.nextInt();
		list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(10);
		list.add(50);
		if(N == 1) {
			System.out.println(4);
			System.exit(0);
		}
		for(int i = 2 ; i <= N ; i++) {
			answer.clear();
			for(int n = 0 ; n <= 3;n++) {
				for(int k = 0 ; k < list.size(); k++) {
					if(list.get(k)+num[n]<=N*50 &&!answer.contains(list.get(k)+num[n])) {
						answer.add(list.get(k)+num[n]);
					}
				}
			}
			list.clear();
			list = (ArrayList<Integer>) answer.clone();
		}
		System.out.println(answer.size());
	}
}
