package algo.study;

import java.util.Scanner;

public class Babygin_Swap {
	
	static char[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		arr = new Integer(input).toString().toCharArray();
		//재귀 호출
		permutation(0); //파라미터? 인덱스?
		//모든 경우를 보고왔는데,
		System.out.println(new String(arr)+"은 베이비진이 아닙니다.");

	}

	public static void permutation(int k) {
		if (k == arr.length) {
			String str = new String(arr);
			System.out.println(str);
			int runCnt = runCheck(arr);
			int tripletCnt = 0;
			//run-run일 경우도 있으니까.
			if(runCnt != 2) {
				tripletCnt = tripletCheck(arr);
			}
			if(runCnt+tripletCnt ==2) {
				System.out.println(new String(arr) + " 은 베이비진입니다");
				System.exit(0);
			}
			return;
		}
		// ?? 같은 숫자를 잡고 돌리는 경우가 존재하는데, 이런 경우는 어떻게 처리할 건지?
		for(int i = k ; i< arr.length; i++) {
			swap(i,k);
			permutation(i+1);
			swap(i,k);
		}
	}
	//런을 체크하는 함수
	public static int runCheck(char[] arr) {
		int count = 0;
		if((arr[0] == arr[1]+1 && arr[1]+1 == arr[2]+2)||(arr[0]+2 == arr[1]+1 && arr[1]+1 == arr[2])) {
			count++;
		}
		if((arr[3] == arr[4]+1 && arr[4]+1 == arr[5]+2)||(arr[3]+2 == arr[4]+1 && arr[4]+1 == arr[5])) {
			count++;
		}
		return count;
		
	}
	//트리플럿을 보는 함수
	public static int tripletCheck(char[] arr) {
		int count = 0;
		if(arr[0] == arr[1] && arr[1] == arr[2]) {
			count++;
		}
		if(arr[3] == arr[4] && arr[4] == arr[5]) {
			count++;
		}
		return count;
		
	}
	//스왑
	public static void swap(int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
