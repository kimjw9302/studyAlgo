	package algo.study;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class Main_말이되고픈원숭이 {
		static int[][][] used;
		static boolean[][] visited;
		static int[][] map;
		static int W, H, K;
		static int answer;
		static int[] di = { 0, 1, 0, -1 };
		static int[] dj = { 1, 0, -1, 0 };
		static int[] hdi = { -2, -2, 2, 2, 1, -1, 1, -1 };
		static int[] hdj = { -1, 1, -1, 1, -2, -2, 2, 2 };
	
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			used = new int[H][W][K + 1];
			answer = Integer.MAX_VALUE;
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
					for (int k = 0; k <= K; k++) {
						used[h][w][k] = Integer.MAX_VALUE;
					}
				}
			}
			// 로직, 시작점 (0,0) 마지막점, (H-1,W-1)
			Queue<Horse> move = new LinkedList<>();
			move.add(new Horse(0, 0, K, 0));
			boolean isEnd = false;
			while (!move.isEmpty()) {
				Horse now = move.poll();
				if (now.i == H - 1 && now.j == W - 1) {
					answer = Math.min(answer, now.time);
					isEnd = true;
					break;
				}
				used[now.i][now.j][now.item]= now.time; 
				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					// 범위 안에 있고, 움직 일 수 있는 곳이면
					if (isBoundary(nexti, nextj) && map[nexti][nextj] == 0) {
						// 4방향으로 움직일건데, 만약 내가 갈려는 쪽에 이미 누군가 간적이있기 때문에 비교를 해야합니다. 내가 움직인 시간 보다 적게 걸렸으면 가야합니다.
						if (used[nexti][nextj][now.item] > now.time + 1) {
							used[nexti][nextj][now.item] = now.time+1; 
	//						System.out.println("1)" +nexti + " // " +nextj + " // "+now.item + " // "+(now.time+1));
							move.add(new Horse(nexti, nextj, now.item, now.time + 1));
						}
					}
				}
				// 기회가 있으면?
				if (now.item > 0) {
					for (int d = 0; d < 8; d++) {
						int nexti = now.i + hdi[d];
						int nextj = now.j + hdj[d];
						// 범위 안에 있고, 움직 일 수 있는 곳이면
						if (isBoundary(nexti, nextj) && map[nexti][nextj] == 0) {
							if (used[nexti][nextj][now.item-1] > now.time + 1) {
								used[nexti][nextj][now.item-1] = now.time+1; 
	//							System.out.println("2)"+nexti + " // " +nextj + " // "+(now.item-1) + " // "+(now.time+1));
								move.add(new Horse(nexti, nextj, now.item-1, now.time + 1));
							}
						}
					}
				}
			}
			answer = (isEnd) ? answer : -1;
			System.out.println(answer);
		}
		private static boolean isBoundary(int nexti, int nextj) {
			return nexti >= 0 && nexti < H && nextj >= 0 && nextj < W;
		}
		static class Horse {
			int i, j;
			int item;
			int time;
			public Horse(int i, int j, int item, int time) {
				this.i = i;
				this.j = j;
				this.item = item;
				this.time = time;
			}
			@Override
			public String toString() {
				return "Horse [i=" + i + ", j=" + j + ", item=" + item + "]";
			}
		}
	
	}
