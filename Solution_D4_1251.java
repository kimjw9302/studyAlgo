package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251 {
	static int TC, N;
	static double E;
	static int[] XX;
	static int[] YY;
	static int[] disjoint;
	static ArrayList<Edge> mst; 
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			XX = new int[N];
			YY = new int[N];
			mst = new ArrayList<>();
			pq = new PriorityQueue<>();
			disjoint = new int[N+1];
			for(int i = 1 ; i<=N;i++) {
				disjoint[i]= i;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				XX[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				YY[j] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			for(int i = 0 ; i < N ;i++) {
				for(int j = i+1; j<N ;j++) {
					pq.add(new Edge((i+1),(j+1),calValue(i,j)*E));
				}
			}
			double answer =0;
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				if(find(now.start)!=find(now.end)) {
					mst.add(now);
					union(now.start,now.end);
				}
			}
			for (Edge e : mst) {
				answer += e.value;
			}
			System.out.println("#"+tc + " "+Math.round(answer));
		}
	}
	public static void union(int n1,int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if(p1!=p2) {
			disjoint[p1] = p2;
		}
	}
	public static int find(int n) {
		if(disjoint[n] == n) {
			return n;
		}
		disjoint[n] = find(disjoint[n]);
		return disjoint[n];
	}
	private static double calValue(int n1,int n2) {
		double d = Math.pow(XX[n1]-XX[n2], 2) +	Math.pow(YY[n1]-YY[n2], 2);
		return d;
	}

	static class Edge implements Comparable<Edge>{
		int start, end;
		double value;

		Edge(int i, int j, double v) {
			this.start = i;
			this.end = j;
			this.value = v;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(o.value>this.value) {
				return -1;
			}
			return 1;
		}
	}
}
