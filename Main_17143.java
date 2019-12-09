package algo.study;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17143 {
	static int R, C, M;
	static int[][] map;
	static int answer = 0;
	static Shark[] sharks;
	static boolean[] used;
	static int[][] tempmap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // i크기
		C = sc.nextInt(); // j크기
		M = sc.nextInt(); // 상어정보개수
		map = new int[R + 1][C + 1]; // 격자판 (인트로 한 이유) => 상어들에 대한 순번을 매길거기 때문
		// sharks = new LinkedList<>(); // 상어들을 모아두기 위한 리스트 ? 배열이 나을려나?
		sharks = new Shark[M + 1];
		tempmap = new int[R + 1][C + 1];
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			// sharks.add(new Shark(m + 1, r, c, s, d, z));
			sharks[m + 1] = new Shark(m + 1, r, c, s, d, z);
			used = new boolean[m + 1];
			map[r][c] = m + 1; // 맵에 상어의 인덱스를 찍어줍니다.
		}
		for (int c = 1; c <= C; c++) { // int c 는 낚시왕의 위치를 나타내게할거야.

			// 낚시왕 은 이동을하고 바로 행으로 작살을 쏜다.
			shoot(c); // -> 낚시왕이 작살을 쏘고 가장 가까운놈을 잡고 격자판에서 사라짐.
			tempmap = new int[R + 1][C + 1];
			move(); // -> 상어의 이동을 구현한 함수 - 같은칸에 옮겨놨는데 있다면, 큰놈이 작은놈을 먹는다.
		}
		System.out.println(answer);
	}

	public static void print(int[][] arr) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void move() {
		// 템프맵 새로초기화
		tempmap = new int[R + 1][C + 1];
		for (int i = 1; i < sharks.length; i++) {
			Shark now = sharks[i];
			// 상어가 존재한다면, 한 방향으로 이동시켜야함.
			if (now != null) {
				if(now.d == 1 || now.d ==2) {
					now.s = now.s%(R*2-2);
				}else {
					now.s = now.s%(C*2-2);
				}
				for (int s = 1; s <= now.s; s++) { // 하나하나씩 가다가 변경사항이있으면 바로바로 변경해줘 체크하기..
					switch (now.d) {
					case 1: // 상 ,r - 속력
						// 상으로 움직일건데 ?
						// 내위치 먼저보기.
						if (now.r == 1) {// 시작하자마자 위치가 끝에있고, 위를 바라본다면,
							now.r++;
							now.d = 2;
							break;
						} else {
							now.r--;
							break;
						}
					case 2: // 하
						// 밑으로 움직일건데
						// 내위치 먼저보기
						if (now.r == R) {
							now.r--;
							now.d = 1;
							break;
						} else {
							now.r++;
							break;
						}
						// System.out.println("하!!");
					case 3: // 우
						// 오른쪽으로 움직일건데
						// 내위치먼저보기
						if (now.c == C) {
							now.c--;
							now.d = 4;
							break;
						} else {
							now.c++;
							break;
						}
						// System.out.println("우!!");
					case 4: // 좌
						if (now.c == 1) {
							now.c++;
							now.d = 3;
							break;
						} else {
							now.c--;
							break;
						}
						// System.out.println("좌!!");
					}
				}

				if (tempmap[now.r][now.c] != 0) { // 옮길라하는데, 상어가 있넹..?
					int num = tempmap[now.r][now.c];
					Shark s = sharks[num];
					if (s.z > now.z) {// 기존에 알박하고 있던 a상어가 더 크기가 큼. 들어올려는 놈이 먹힘.
						sharks[now.idx] = null;
					} else {
						sharks[s.idx] = null;
						tempmap[now.r][now.c] = now.idx;
					}
				} else {
					tempmap[now.r][now.c] = now.idx;
				}
			}
			copy();
		}
	}

	public static void copy() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = tempmap[i][j];
			}
		}
	}

	public static void shoot(int c) {
		for (int i = 1; i <= R; i++) {
			if (map[i][c] != 0) { // 상어가 존재했다 -> 격자판에서 사라지게
				// System.out.println(i+ ","+c);
				// System.out.println(map[i][c]);
				answer = answer + sharks[map[i][c]].z;
				int sharkNum = map[i][c];
				map[i][c] = 0;
				sharks[sharkNum] = null;
				return;
			}
		}
	}

	static public class Shark {
		int idx;
		int r; // 상어 위치
		int c; // 상어 위치
		int s; // 상어 속력
		int z; // 상어 크기
		int d;

		Shark(int idx, int r, int c, int s, int d, int z) {
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}