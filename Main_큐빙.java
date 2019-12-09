package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_큐빙 {
	static int TC, N;
	static char[][] up, down, front, left, right, back;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			init();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; st.hasMoreTokens(); i++) {
				String word = st.nextToken();
				char loca = word.charAt(0); // 어느 면?
				char dir = word.charAt(1); // 돌리는 방향?
				Rotate(loca, dir);
//				System.out.println("!!!!!!!!!!!!!!!!!!");
//				print(up);
//				System.out.println("==");
//				print(front);
//				System.out.println("==");
//				print(left);
//				System.out.println("==");
//				print(right);
//				System.out.println("==");
//				print(down);
//				System.out.println("==");
//				print(back);
				
			}
			print(up);
			
		}
		System.out.print(sb.toString());
	}

	public static void print(char[][] tmp) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
//				System.out.print(tmp[i][j]);
				sb.append(tmp[i][j]);
			}
			sb.append("\n");
//			System.out.println();
		}
	}

	private static void fill(char[][] tmp, char ch) {
		for (int i = 0; i < 3; i++) {
			Arrays.fill(tmp[i], ch);
		}
	}

	private static void init() {
		up = new char[3][3];
		down = new char[3][3];
		front = new char[3][3];
		back = new char[3][3];
		left = new char[3][3];
		right = new char[3][3];

		fill(up, 'w');
		fill(down, 'y');
		fill(front, 'r');
//		Arrays.fill(back[0],'a');
//		Arrays.fill(back[1],'c');
//		Arrays.fill(back[2],'b');
		fill(back,'o');
		fill(left, 'g');
		fill(right, 'b');
	}

	private static void Rotate(char loca, char dir) {

		switch (loca) {
		case 'U':
			rotating(up, dir);
			if (dir == '-') {
				up_rotate();
				up_rotate();
				up_rotate();
			} else {
				up_rotate();
			}

			break;
		case 'D':
			rotating(down, dir);
			if (dir == '-') {
				down_rotate();
				down_rotate();
				down_rotate();
				
			} else {
				down_rotate();
			}
			break;
		case 'F':
			rotating(front, dir);
			if (dir == '-') {
				front_rotate();
				front_rotate();
				front_rotate();
			} else {
				front_rotate();
			}
			break;
		case 'B':
			dir = (dir=='-')? '+':'-';
			rotating(back, dir);
			if (dir == '-') {
				back_rotate();
				
			} else {
				back_rotate();
				back_rotate();
				back_rotate();
			}
			break;
		case 'L':
			rotating(left, dir);
			if (dir == '-') {
				left_rotate();
				left_rotate();
				left_rotate();
			} else {
				left_rotate();

			}
			break;
		case 'R':
			rotating(right, dir);
			if (dir == '-') {
				right_rotate();
				right_rotate();
				right_rotate();

			} else {
				right_rotate();
			}
			break;

		}

	}

	private static void right_rotate() {
		char[] change1, change2;
		change1 = new char[3];
		change2 = new char[3];
		for(int i = 0 ; i < 3 ; i++) change1[i] = up[i][2];
		for(int i = 0 ; i < 3 ; i++) up[i][2] = front[i][2];

		for(int i = 0 ; i < 3 ; i++) change2[i] = back[i][2];
		for(int i = 0 ; i < 3 ; i++) back[i][2] = change1[2-i];
		
		for(int i = 0 ; i < 3 ; i++) change1[i] = down[i][2];
		for(int i = 0 ; i < 3 ; i++) down[i][2] = change2[2-i];
		for(int i = 0 ; i < 3 ; i++) front[i][2] = change1[i];

	}

	//left자체  front a b c  -> down abc -> back cba  -> back cba -> up abc
	private static void left_rotate() {
		char[] change1, change2;
		change1 = new char[3];
		change2 = new char[3];
		for(int i = 0 ; i < 3 ; i++) change1[i] = up[i][0];
		for(int i = 0 ; i < 3 ; i++) up[i][0] = back[2-i][0];
		
		for(int i = 0 ; i < 3 ; i++) change2[i] = front[i][0];
		for(int i = 0 ; i < 3 ; i++) front[i][0] = change1[i];

		for(int i = 0 ; i < 3 ; i++) change1[i] = down[i][0];
		for(int i = 0 ; i < 3 ; i++) down[i][0] = change2[i];
		for(int i = 0 ; i < 3 ; i++) back[i][0] = change1[2-i];
	}
	private static void back_rotate() { //시계
		char[] change1, change2;
		change1 = new char[3];
		change2 = new char[3];
		for(int i = 0 ; i < 3 ; i++) change1[i] = up[0][i];
		for(int i = 0 ; i < 3 ; i++) up[0][i] = right[i][2];
		
		for(int i = 0 ; i < 3 ; i++) change2[i] = left[i][0];
		for(int i = 0 ; i < 3 ; i++) left[i][0] = change1[2-i];
		
		for(int i = 0 ; i < 3 ; i++) change1[i] = down[2][i];
		for(int i = 0 ; i < 3 ; i++) down[2][i] = change2[i];
		for(int i = 0 ; i < 3 ; i++) right[i][2] = change1[2-i];
	}

	private static void front_rotate() { //시계
		char[] change1, change2;
		change1 = new char[3];
		change2 = new char[3];
		for(int i = 0 ; i < 3 ; i++) change1[i] = up[2][i];
		for(int i = 0 ; i < 3 ; i++) up[2][i] = left[2-i][2];
		
		for(int i = 0 ; i < 3 ; i++) change2[i] = right[i][0];
		for(int i = 0 ; i < 3 ; i++) right[i][0] = change1[i];
		
		for(int i = 0 ; i < 3 ; i++) change1[i] = down[0][i];
		for(int i = 0 ; i < 3 ; i++) down[0][i] = change2[2-i];
		for(int i = 0 ; i < 3 ; i++) left[i][2] = change1[i];

	}

	private static void down_rotate() { //시계방향
		char[] change1, change2;
		change1 = new char[3];
		change2 = new char[3];
		for(int i = 0 ; i < 3 ; i++) change1[i] = front[2][i];
		for(int i = 0 ; i < 3 ; i++) front[2][i] = left[2][i];
		
		for(int i = 0 ; i < 3 ; i++) change2[i] = right[2][i];
		for(int i = 0 ; i < 3 ; i++) right[2][i] = change1[i];
		
		for(int i = 0 ; i < 3 ; i++) change1[i] = back[2][i];
		for(int i = 0 ; i < 3 ; i++) back[2][i] = change2[2-i];
		for(int i = 0 ; i < 3 ; i++) left[2][i] = change1[2-i];
	}
	private static void up_rotate() {//무조건 시계
		char[] change1, change2;
		change1 = new char[3];
		change2 = new char[3];
		for(int i = 0 ; i < 3 ; i++) change1[i] = front[0][i];
		for(int i = 0 ; i < 3 ; i++) front[0][i] = right[0][i];
		
		for(int i = 0 ; i < 3 ; i++) change2[i] = left[0][i];
		for(int i = 0 ; i < 3 ; i++) left[0][i] =change1[i];
		
		for(int i = 0 ; i < 3 ; i++) change1[i] = back[0][i];
		for(int i = 0 ; i < 3 ; i++) back[0][i] = change2[2-i];
		for(int i = 0 ; i < 3 ; i++) right[0][i] = change1[2-i];
	}


	private static void rotating(char[][] tmp, char dir) {
		// 자기자신 변경
		// - 반시계 , + 시계
		for (int k = 0; k < 2; k++) {

			if (dir == '-') {
				char temp = tmp[0][0];
				for (int i = 0; i < 2; i++) {
					tmp[0][i] = tmp[0][i + 1];
				}
				for (int i = 0; i < 2; i++) {
					tmp[i][2] = tmp[i + 1][2];
				}
				for (int i = 2; i > 0; i--) {
					tmp[2][i] = tmp[2][i - 1];
				}
				for (int i = 2; i > 1; i--) {
					tmp[i][0] = tmp[i - 1][0];
				}
				tmp[1][0] = temp;
			} else {
				char temp = tmp[0][0];
				for (int i = 0; i < 2; i++) {
					tmp[i][0] = tmp[i + 1][0];
				}
				for (int i = 0; i < 2; i++) {
					tmp[2][i] = tmp[2][i + 1];
				}
				for (int i = 2; i > 0; i--) {
					tmp[i][2] = tmp[i - 1][2];
				}
				for (int i = 2; i > 1; i--) {
					tmp[0][i] = tmp[0][i - 1];
				}

				tmp[0][1] = temp;
			}
		}
	}

}