package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16937 {
	static int H, W, N;
	static int tempH, tempW;
	static ArrayList<Sticker> stics;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		tempH = H;
		tempW = W;
		answer = 0;
		stics = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			stics.add(new Sticker(i, j, H, W));
			stics.add(new Sticker(j,i,H,W));
		}
		visited = new boolean[stics.size()];
//		print(stics);
		pick(0 , 2);
		pick(1,2);
		System.out.println(answer);
	}

	public static void pick(int idx, int cnt) {
		if (cnt == 0) {
			int sum = 0;
			for(int i = 0 ; i < visited.length;i++) {
				if(visited[i]) {
					sum+=stics.get(i).size;
				}
			}
//			System.out.println(Arrays.toString(visited));
			answer = Math.max(sum, answer);
			return;
		}
		int bb = 0;
		if(idx%2==0) {
			bb = idx+1;
		}else {
			bb= idx-1;
		}
		for (int i = 0; i < stics.size(); i++) {
			//자기자신 인데 반대인경우인놈은 비교하면안되지..
			if (!visited[i]&&i!=bb) {
				boolean isP = isPossible(stics.get(i));
				if(isP) {
					visited[i] = true;
					pick(i, cnt - 1);
					Sticker s = stics.get(i);
					if(s.flag) {
						tempH+=s.i;
						tempW+=s.j;
					}else {
						tempH+=s.j;
						tempW+=s.i;
					}
					visited[i] = false;
				}
			}
		}
	}
	
	public static boolean isPossible(Sticker s) {
		// H , W
//		System.out.println(s.i + " , " +s.j+ " // "+tempH + " , " +tempW);
		boolean colOk = false;
		boolean rowOk = false;
		// 정으로 비교,
		if (tempH >= s.i && W>=s.j)
//				return true;
			colOk = true;
		if (tempW>= s.j&&H>=s.i)
//			return true;
			rowOk = true;
		if (rowOk || colOk) {
			tempH -= s.i;
			tempW -= s.j;
			s.flag = true;
			return true;
		}
		// 역으로 비교
		if (tempW >= s.i && H >= s.j)
			colOk = true;
		if (tempH >= s.j && W >=s.i)
			rowOk = true;
		if (rowOk ||colOk) {
			tempW-=s.i;
			tempH-=s.j;
			s.flag = false;
			return true;
		}
		return false;
	}

	public static void print(ArrayList<Sticker> aa) {
		for (Sticker s : aa) {
			System.out.println(s.i + " , " + s.j + " , " + s.size);
		}
	}

	static class Sticker {
		int h, w;
		int i, j;
		int size;
		boolean flag = false;
		Sticker(int i, int j, int h, int w) {
			this.i = i;
			this.j = j;
			this.h = h;
			this.w = w;
			this.size = i * j;
		}

	}

}
