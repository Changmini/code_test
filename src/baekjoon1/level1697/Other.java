package baekjoon1.level1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Other {
	
	static int K = 0;
	static char[] oper = { '-', '+', '*'};
	static int[] move = { 1, 1, 2 };
	static int[] time = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		boolean run = (N!=K);
		Queue<Integer> currentLevel = new LinkedList<Integer>();
		currentLevel.add(N);
		int pos = 0;
		while(run && !currentLevel.isEmpty()) {
			pos = currentLevel.poll();
			for (int i = 0; i < move.length; i++) {
				int tmp = calc(oper[i], move[i], pos);
				if (tmp < 0 || tmp > 100000 || time[tmp] > 0)
					continue;
				time[tmp] = time[pos] + 1;
				if (tmp == K) {
					pos = tmp;
					run = false;
					break;
				}
				currentLevel.add(tmp);
			}
		}
		System.out.println(time[pos]);
	}
	
	static int calc(char o, int m, int pos) {
		int res = 0;
		switch(o) {
			case '-':
				res = pos - m;
				break;
			case '+':
				res = pos + m;
				break;
			case '*':
				res = pos * m;
				break;
			default: break;
		}
		return res;
	}
	
}