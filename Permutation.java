package algo.study;

import java.util.Scanner;

public class Permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		arr = new Integer(input).toString().toCharArray();
		permutation(arr.length, 0);
	}
}
