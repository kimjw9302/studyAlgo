package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499 {
	static int N, M, fi, fj, K;
	static int[][] map;
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { 1, -1, 0, 0 };
	static Node zero,one,two,three,four,five;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fi = Integer.parseInt(st.nextToken());
		fj = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		makeCube();
		Node now = zero;
		for (;st.hasMoreTokens();) {
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int nexti = fi + di[dir];
			int nextj = fj + dj[dir];
			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M) {
				System.out.println(nexti + ","+nextj);
				switch (dir+1) {
				case 1: // ->
					fi = nexti;
					fj = nextj;
					if(map[fi][fj]==0) {
						map[fi][fj] = now.data;
					}else {
						now = now.right;
						now.bandae.data = map[fi][fj];
						System.out.println(now.data);
					}
					break;
				case 2:// <-
					fi = nexti;
					fj = nextj;
					if(map[fi][fj]==0) {
						map[fi][fj] = now.data;
					}else {
						now = now.left;
						now.bandae.data = map[fi][fj];
						System.out.println(now.data);
					}
					break;
				case 3: // 위로
					fi = nexti;
					fj = nextj;
					if(map[fi][fj]==0) {
						map[fi][fj] = now.data;
					}else {
						now = now.up;
						now.bandae.data = map[fi][fj];
						System.out.println(now.data);
					}
					break;
				case 4:// 아래로
					fi = nexti;
					fj = nextj;
					if(map[fi][fj]==0) {
						map[fi][fj] = now.data;
					}else {
						now = now.down;
						now.bandae.data = map[fi][fj];
						System.out.println(now.data);
					}
					break;
				}
			}
		}

	}

	public static void makeCube() {
		zero = new Node(0);
		one = new Node(0);
		two = new Node(0);
		three = new Node(0);
		four = new Node(0);
		five = new Node(0);
		zero.set(three, one, four, five, two);
		one.set(zero, two, four, five, three);
		two.set(one, three, four, five, zero);
		three.set(two, zero, five, four, one);
		four.set(three, one, two, zero, five);
		five.set(three, one, zero, two, five);
	}

	static public class Node {
		int data;
		Node up;
		Node down;
		Node left;
		Node right;
		Node bandae;

		Node(int data) {
			this.data = data;
		}

		void set(Node up, Node down, Node left, Node right, Node bandae) {
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
			this.bandae = bandae;
		}
	}
}
