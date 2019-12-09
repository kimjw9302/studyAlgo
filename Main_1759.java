package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_1759 {
	static int L, C;
	static char[] word;
	static boolean[] visited;
	static LinkedList<Character> answer;
	static Set<String> treeset;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[C];
		answer = new LinkedList<>();
		word = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(word);
		treeset = new TreeSet<>();
//		System.out.println(Arrays.toString(word));
		dfs(0,0);
		Iterator<String> it = treeset.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static boolean check() {
		boolean flag = false;
		int mo = 0, ja = 0;
		for (int i = 0; i < L; i++) {
			if ('a' == answer.get(i) || 'i' == answer.get(i) || 'e' == answer.get(i) || 'o' == answer.get(i) || 'u' == answer.get(i)) {
				mo++;
			} else {
				ja++;
			}
		}
		if (mo >= 1 && ja >= 2) {
			flag = true;
		}
		
		return flag;
	}

	public static void dfs(int index,int cnt) {
		if(index >=6) {
			if(answer.size() == 4&&check()) {
				for (Character character : answer) {
					System.out.print(character);
				}
				System.out.println();
				
			}
			return;
		}
		answer.add(word[index]);
		dfs(index+1,cnt+1);
		answer.removeLast();
		dfs(index+1,cnt);
		
	}
}
