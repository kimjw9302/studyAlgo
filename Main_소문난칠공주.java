import java.io.*;
import java.util.*;
/*
  로직
  1) 조합으로 7개의 숫자를 뽑는다(중복x)
  2) 가지치기 실행( 도연의 숫자가 3 초과면 가지치기) -> index/5 : 행 index%5 : 열 이됨
  3) 7명을 뽑았다면, 서로 연결되어있는지 확인한다.(BFS활용)
*/
public class Main_소문난칠공주 {
	static char[][] map;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static boolean[] checked;
	static boolean[][] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		visited = new boolean[5][5];
		checked = new boolean[26];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 7명 픽하기
		int[] picks = new int[8];
		setting(picks, 0, 1, 0, 0, 1);
		System.out.println(answer);
	}

	private static void setting(int[] arr, int tot, int idx, int y_cnt, int s_cnt, int limit) {
		if (y_cnt > 3) {
//			System.out.println("도연이가 많네");
			return;
		}
		if (tot == 7) {
//			System.out.println(Arrays.toString(arr));
			// 연결되어있는지 확인해보자
//			System.out.println("!");
			visited = new boolean[5][5];
			for (int i = 1; i < arr.length; i++) {
				visited[(arr[i] - 1) / 5][(arr[i] - 1) % 5] = true;
			}
//			for (int i = 0; i < 5; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			bfs(arr);
			return;
		}
		for (int i = limit; i < 26; i++) {
			if (!checked[i]) {
				checked[i] = true;
				arr[idx] = i;
				int temp = arr[idx];
				int tempy_cnt = (map[(i - 1) / 5][(i - 1) % 5] == 'Y') ? y_cnt + 1 : y_cnt;
				int temps_cnt = (map[(i - 1) / 5][(i - 1) % 5] == 'S') ? s_cnt + 1 : s_cnt;
				setting(arr, tot + 1, idx + 1, tempy_cnt, temps_cnt, i + 1);
				arr[idx] = temp;
				checked[i] = false;
			}

		}
	}

	private static void bfs(int[] arr) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node((arr[1] - 1) / 5,(arr[1] - 1) % 5));
		int qsize = 1;
		boolean[][] temp = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				temp[i][j] = visited[i][j];
			}
		}
		visited[(arr[1] - 1) / 5][(arr[1] - 1) % 5] = false;
		while(!que.isEmpty()) {
			Node now = que.poll();
			for(int d = 0 ; d< 4; d++) {
				int nexti = now.i+di[d];
				int nextj = now.j+dj[d];
				if(nexti>=0 && nexti<5 &&nextj>=0 &&nextj<5&&visited[nexti][nextj]) {
					visited[nexti][nextj] = false;
					que.add(new Node(nexti,nextj));
					qsize++;
				}
			}
		}
		answer = (qsize==7)? answer+1: answer;
	}

	static class Node {
		int i, j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
