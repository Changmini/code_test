package baekjoon.level11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Position[] p = new Position[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Position(x, y);
		}
		
		Arrays.sort(p);
		
		StringBuilder sb = new StringBuilder();
		for (Position t : p) {
			sb.append(t.x + " " + t.y).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
class Position implements Comparable<Position> {
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Position o) {
		int temp = this.x - o.x;
		if (temp != 0) {
			return temp;
		} else {
			return this.y - o.y;
		}
	}

}