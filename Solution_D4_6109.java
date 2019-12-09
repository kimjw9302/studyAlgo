package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_6109 {
	static int TC, N;
	static char dir;
	static int[][] map;
	static int[][] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			answer = new int[N][N];
			dir = st.nextToken().charAt(0);
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			switch (dir) {
			case 'u':
				for (int j = 0; j < N; j++) {
					Queue<Integer> que = new LinkedList<>();
					for (int i = 0; i < N; i++) {
						if (map[i][j] == 0)
							continue;
						else
							que.add(map[i][j]);
					}
					int index = 0;
//					System.out.println(que);
					if (que.size() <= 0) {
						continue;
					} else {
						while (!que.isEmpty()) {

							int now = que.poll();
							int next = 0;
							if (que.size() <= 0) {
								answer[index][j] = now;
							} else {
								next = que.peek();
								index++;
								if (now == next) {
//									System.out.println("1)"+now+","+next);
									answer[index - 1][j] = now + next;
									que.poll();
								} else {
//									System.out.println("2)"+now+","+next);
									answer[index - 1][j] = now;
//									answer[index][j] = next;
//									index++;
								}
							}
						}
					}
				}
				break;
			case 'd':
				for (int j = 0; j < N; j++) {
					Queue<Integer> que = new LinkedList<>();
					for (int i = N-1; i >=0; i--) {
						if (map[i][j] == 0)
							continue;
						else
							que.add(map[i][j]);
					}
					int index = N;
//					System.out.println(que);
					if (que.size() <= 0) {
						continue;
					} else {
						while (!que.isEmpty()) {

							int now = que.poll();
							int next = 0;
							if (que.size() <= 0) {
								answer[index-1][j] = now;
							} else {
								next = que.peek();
								index--;
								if (now == next) {
//									System.out.println("1)"+now+","+next);
									answer[index][j] = now + next;
									que.poll();
								} else {
//									System.out.println("2)"+now+","+next);
									answer[index][j] = now;
//									answer[index-1][j] = next;
//									index--;
								}
							}
						}
					}
				}
				break;
			case 'r':
				for(int i = 0 ; i < N ; i++) {
					Queue<Integer> que = new LinkedList<>();
					for(int j = N-1 ; j >=0 ; j--) {
						if (map[i][j] == 0)
							continue;
						else
							que.add(map[i][j]);
					}
					int index = N;
//					System.out.println(que);
					if (que.size() <= 0) {
						continue;
					} else {
						while(!que.isEmpty()) {
							int now = que.poll();
							int next = 0;
							if (que.size() <= 0) {
								answer[i][index-1] = now;
							} else {
								next = que.peek();
								index--;
								if (now == next) {
//									System.out.println("1)"+now+","+next);
									answer[i][index] = now + next;
									que.poll();
								} else {
//									System.out.println("2)"+now+","+next);
									answer[i][index] = now;
								}
							}
						}
					}
				}
				break;
			case 'l':
				for(int i = 0 ; i < N ; i++) {
					Queue<Integer> que = new LinkedList<>();
					for(int j = 0 ; j <N ; j++) {
						if (map[i][j] == 0)
							continue;
						else
							que.add(map[i][j]);
					}
					int index = 0;
//					System.out.println(que);
					if (que.size() <= 0) {
						continue;
					} else {
						while(!que.isEmpty()) {
							int now = que.poll();
							int next = 0;
							if (que.size() <= 0) {
								answer[i][index]= now;
							} else {
								next = que.peek();
								index++;
								if (now == next) {
//									System.out.println("1)"+now+","+next);
									answer[i][index-1] = now + next;
									que.poll();
								} else {
//									System.out.println("2)"+now+","+next);
									answer[i][index-1] = now;
//									answer[i][index] = next;
//									index++;
								}
							}
						}
					}
				}
				break;
			}
			System.out.println("#"+tc);
			print();
		}
	}

	public static void print() {
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();

		}
	}
}
