package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main_Jungol_590 {
	static int N;
	static boolean[] used;
	static Set<String> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr;
		arr = new int[N];
		answer = new TreeSet<>();
		used = new boolean[7];
		dfs(arr,6, 0);
		ArrayList<Integer> que = new ArrayList<>();
		que.get(0).pri
		Iterator<String> it = answer.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void dfs(int[] arr,int index, int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(arr));
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(int i = 0 ; i < N ; i++) {
				pq.add(arr[i]);
			}
			StringBuilder sb = new StringBuilder();
			while(!pq.isEmpty()) {
				sb.append(pq.poll()+" ");
			}
			answer.add(sb.toString());
			return;
		}
		
		for(int i = index; i >=1  ; i--) {
			arr[cnt] = i;
			dfs(arr,i, cnt+1);
		}
	}
}
