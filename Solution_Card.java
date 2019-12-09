package algo.study;
import java.util.*;
public class Solution_Card {
	static class Node {
		int[] arr;
		int cnt;
		Node(int[] arr, int cnt) {
			this.arr = arr;
			this.cnt = cnt;
		}
	}
	static boolean asc(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}
	static boolean desc(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1])
				return false;
		}
		return true;
	}
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			int ans = -1;
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(arr, 0));
			//BFS
			while (!q.isEmpty()) {
				Node c = q.poll();
				if (c.cnt > 5) //5번 초과되면 종료되기 위해 que를 계속 poll함. 
					continue;
				
				if (asc(c.arr) || desc(c.arr)) { //정렬이 되었다면 종료
					ans = c.cnt;
					break;
				}
				
				int m = 1;
				
				for (int k = 1; k < N; k++) { 
					for (int i = N / 2 - m; i < N / 2 + m; i += 2)
						swap(c.arr, i, i + 1);
					if (k >= N / 2)
						m--;
					else
						m++;
					int tmp[] = new int[N];
					for (int i = 0; i < N; i++)
						tmp[i] = c.arr[i];
					q.add(new Node(tmp, c.cnt + 1));
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}