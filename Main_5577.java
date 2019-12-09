package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_5577 {
	static int N; // 공의 개수
	static final int RED = 1;
	static final int BLUE = 2;
	static final int YELLOW = 3;
	static Queue<Info> que; // 스케줄링을 위한 큐
	static int min = Integer.MAX_VALUE;
	static int[] num;
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
//			System.out.println((i+1)+"번째");
			int now = num[i];
			if (now == BLUE) {
				que.add(new Info(swap(num, i, YELLOW)));
				bomb();
				que.add(new Info(swap(num, i, RED)));
				bomb();
			} else if (now == YELLOW) {
				que.add(new Info(swap(num, i, RED)));
				bomb();
				que.add(new Info(swap(num, i, BLUE)));
				bomb();
			} else if (now == RED) {
				que.add(new Info(swap(num, i, BLUE)));
				bomb();
				que.add(new Info(swap(num, i, YELLOW)));
				bomb();
			}
		}
		if (N <= 2) {
			min = N;
		}
		System.out.println(min);

	}

	// 터진개수를 제외한 현재 남아있는 공의 개수를 찾기 위한 함수
	public static int sizeCheck(int[] arr) {
		int size = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] != -1) {
				size++;
			}
		}
		return size;
	}

	// 터트리자!
	public static void bomb() {
		while (!que.isEmpty()) {
			Info info = que.poll();
			int arrsize = sizeCheck(info.arr);
			if (arrsize <= 3) {
				break;
			}
//			System.out.println(Arrays.toString(info.arr));
			for (int i = 0; i < N - 1; i++) {
				int count = 0;
				int minusCount = 0;
				// 자기라 같은거를 찾기위해 , 터진게 존재할경우 {1,1,-1,-1,-1,-1,1}
				for (int j = i + 1; j < N; j++) {
					if (info.arr[j] == -1) { // 터졌던거는 무시
						minusCount++;
						continue;
					}
					if (info.arr[i] == info.arr[j]) { // 터진걸 다무시고 왔는데 기존에 같았던게 존재하면 count++;
						count++;
					} else { // 달랐다면, 바로 포문종료 (더이상 비교해볼 필요가X)
						break;
					}
				}
				// 같은게 4개이상인경우(자기 빼고 비교했으므로 3이상이 맞음)
				if (count >= 3) {
					for (int j = i; j <= i + count + minusCount; j++) { // 터트림!
						info.arr[j] = -1;
					}
					que.add(new Info(info.arr)); // 한번 터졌으니까 다시 스케줄링에 넣어줘야함.
				} else {
					// 바꿔서 했는데 같은게 없어..? 사이즈만 체크해보고, 끝냄
					int arrsize2 = sizeCheck(info.arr);
					if (min > arrsize2) {
						min = arrsize2;
					}
				}
			}
		}
	}

	// 새로운 배열을 만들어서 다시 스케줄링 해줌.(한 인덱스 번호만 바꿔저서 보냄)
	public static int[] swap(int[] arr, int a, int color) {
		int[] tempArr = new int[N];
		tempArr[a] = color;
		for (int i = 0; i < a; i++) {
			tempArr[i] = arr[i];
		}
		for (int i = a + 1; i < N; i++) {
			tempArr[i] = arr[i];
		}
		return tempArr;
	}

	// nested class(열정보를 담고다닐건데..?) 시간부족으로 인해 터지나? 결국 배열을 넘기고 다녀도됐던거같은데?왜만듬
	static class Info {
		int[] arr;

		Info(int[] arr) {
			this.arr = arr;
		}
	}
}
