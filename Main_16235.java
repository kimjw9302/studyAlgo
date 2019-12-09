package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16235 {
	static int N, M, K;
	static int[][] nutri;
	static LinkedList<Tree>[][] trees;
	static ArrayList<Tree> deathNote;
	static Set<Tree> set;
	static int[][] map;
	static int[] di = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static int[] dj = { 1, 0, -1, 0, 1, -1, -1, 1 };
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		// 겨울을 위한 영양소 세팅.
		nutri = new int[N + 1][N + 1];
		deathNote = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				nutri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 5);
		}

		trees = new LinkedList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				trees[i][j] = new LinkedList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees[x][y].add(new Tree(x, y, age));
			set.add(new Tree(x,y,age));
		}
		while (K > 0) {
			spring();
			summer();
			fall();
			winter();
			K--;
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += trees[i][j].size();
			}
		}
		System.out.println(ans);
	}

	static public void print(LinkedList<Tree> tt) {
		for (Tree tree : tt) {
			System.out.println(tree.i + " , " + tree.j + " , " + tree.age);
		}
	}

	static public void print() {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static public void spring() {
		Iterator<Tree> iter = set.iterator();
		while(iter.hasNext()) {
			Tree t = iter.next();
			int i = t.i;
			int j = t.j;
			if(trees[i][j].isEmpty()) continue;
			else {
				LinkedList<Tree> temp = trees[i][j];
				int tSize = temp.size();
				for (int k = tSize - 1; k >= 0; k--) {
					if (map[i][j] - temp.get(k).age < 0) {
						deathNote.add(temp.remove(k));
					} else {
						map[i][j] -= temp.get(k).age;
						temp.get(k).age++;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				
//				if (trees[i][j].size() == 1) {// 나무가 한개일때.
//					Tree t = trees[i][j].get(0);
//					if (map[i][j] - t.age < 0) {
//						deathNote.add(trees[i][j].remove(0));
//					} else {
//						map[i][j] -= t.age;
//						t.age++;
//					}
//				} else if (trees[i][j].size() > 1) { // 나무가 여러개라면 어린 애부터
//					LinkedList<Tree> temp = trees[i][j];
//					int tSize = temp.size();
//					for (int k = tSize - 1; k >= 0; k--) {
//						if (map[i][j] - temp.get(k).age < 0) {
//							deathNote.add(temp.remove(k));
//						} else {
//							map[i][j] -= temp.get(k).age;
//							temp.get(k).age++;
//						}
//					}
//				}
			}
		}
	}

	static public void summer() {
		for (Tree tree : deathNote) {
			int kk = tree.age / 2;
			map[tree.i][tree.j] += kk;
		}
		deathNote.clear();
	}

	static public void fall() {
//		System.out.println("fall ! : "+trees.size());
		LinkedList<Tree> temp = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (trees[i][j].size() != 0) {
					for (Tree tree : trees[i][j]) {
						if (tree.age % 5 == 0) {
							for (int d = 0; d < 8; d++) {
								int nexti = tree.i + di[d];
								int nextj = tree.j + dj[d];
								if (nexti >= 1 && nexti <= N && nextj >= 1 && nextj <= N) {
//									trees[nexti][nextj].add(new Tree(nexti,nextj,1));
									temp.add(new Tree(nexti,nextj,1));
								}
							}
						}
					}
//					System.out.println(temp.size()+" 만큼 생성");
					for (Tree t : temp) {
						trees[t.i][t.j].add(t);
					}
					temp.clear();
				}
			}
		}
	}

	static public void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += nutri[i][j];
			}
		}
	}

	static class Tree{
		int i, j;
		int age;

		Tree(int i, int j, int age) {
			this.i = i;
			this.j = j;
			this.age = age;
		}
	}
}
