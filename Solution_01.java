package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_01 {
	static int TC;
	static int N;
	static Queue<Point> que1;
	static Queue<Point> que2;
	static Map<Point, Integer> map;
	static Map<Point, Integer> map2;
	static Set<Point> check;
	static Iterator<Point> p_it;
	static Iterator<Point> it;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			map2 = new HashMap<>();
			check = new HashSet<>();
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());
				Point p = new Point(i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				map.put(p, p.power);
			}
			int answer = 0;
			int second = 0;
			while (true) {
				if (second > 2000) {
					break;
				}
				second++;
				map2.clear();
				p_it = map.keySet().iterator();
				while (p_it.hasNext()) {
					Point now = p_it.next();
					// 4방향더하기
					switch (now.d) {
					case 0:// 상 i값증가
						now.i += 0.5;
						break;
					case 1:// g하
						now.i -= 0.5;
						break;
					case 2:// 좌
						now.j -= 0.5;
						break;
					case 3:// 우
						now.j += 0.5;
						break;
					}
					if (map2.containsKey(now)) {
//						System.out.println("1)충돌 발생");
						check.add(now);
						answer += now.power;
					} else {
						map2.put(now, now.power);
					}
				}
				it = check.iterator();
				while(it.hasNext()) {
					answer+=map2.remove(it.next());
				}
				check.clear();
				map.clear();
				p_it = map2.keySet().iterator();
				while (p_it.hasNext()) {
					Point now = p_it.next();
					// 4방향더하기
					switch (now.d) {
					case 0:// 상 i값증가
						now.i += 0.5;
						break;
					case 1:// g하
						now.i -= 0.5;
						break;
					case 2:
						now.j -= 0.5;
						break;
					case 3:
						now.j += 0.5;
						break;
					}
					if (map.containsKey(now)) {
//						System.out.println("2)충돌 발생");
						check.add(now);
						answer += now.power;
					} else {
						map.put(now, now.power);
					}

				}
				it = check.iterator();
				while(it.hasNext()) {
					answer+=map.remove(it.next());
				}
				check.clear();
			}
			System.out.println("#" + tc + " " + answer);
		}

	}

	static class Point {
		double i;
		double j;
		int d;
		int power;

		Point(double i, double j, int d, int power) {
			this.i = i;
			this.j = j;
			this.d = d;
			this.power = power;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(i);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(j);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (Double.doubleToLongBits(i) != Double.doubleToLongBits(other.i))
				return false;
			if (Double.doubleToLongBits(j) != Double.doubleToLongBits(other.j))
				return false;
			return true;
		}

	}
}
