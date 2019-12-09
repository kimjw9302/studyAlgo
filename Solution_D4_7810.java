package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_7810{
	static int N, TC;
	static long answer;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;st.hasMoreTokens();i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			Arrays.sort(arr);
			for(int i = 0 ; i < arr.length; i++) {
//				System.out.println(arr[N-i]+ " , "+i);
				if(arr[N-i] >= (i+1)) {
					answer+=1;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
