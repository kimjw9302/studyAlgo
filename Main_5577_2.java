import java.util.Scanner;

public class Main_5577_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ball = new int[N];
		for (int i = 0; i < N; i++)
			ball[i] = sc.nextInt();
		int max = 0;// 공 1개의 색깔을 바꿔서 최대한 많이 터뜨린 갯수 저장
		for (int i = 0; i < N; i++) { // 모든 공의 색깔을 다 한번씩 바꿔 봅시다.
			int origin = ball[i]; // 일단 원래색 기억해놓고
			// 1,2,3 세가지 샊깔로 다한번씩 바꿔보기
			for (int j = 1; j < 4; j++) {
				ball[i] = j;// i번칸의 공을 j색상으로 바꾸고
				int count = 0; // 지금부터 터지는 공의 개수를 저장해봅시다.
				int left = i, right = i;

				while (left >= 0 && right < N && ball[left] == ball[right]) { // 유효범위체크와 left번째와 right번째가 같은지
					int color = ball[left]; // 왼쪽이든 오른쪽이든 일단 지금 봐야하는 색상
					int tmp = 0; // 임시로 일단 4개 이상되서 터뜨릴지 말지 판단할 때 쓸 변수
					while (left >= 0 && ball[left] == color) {
						tmp++;
						if (left == right) //left 랑 right가 같은 인덱스를 가진 경우, 그 공 카운트가 중복해서 세어짐
							tmp--;
						left--;
					}
					while (right < N && ball[right] == color) {
						tmp++;
						right++;
					}

					if (tmp >= 4) { // 현재 세팅한 j번색상의 공이
						count += tmp;
					}
				}
				max = Math.max(max, count); //최대한 터트린개수를 알고 뺴주면되니까!
			}
			ball[i] = origin;
		}
		System.out.println(N-max);
	}
}
