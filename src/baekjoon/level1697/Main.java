package baekjoon.level1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K = 0;
	static char[] oper = { '-', '+', '*'};
	static int[] move = { 1, 1, 2 };
	static boolean[] checked = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		boolean run = (N!=K);
		int count = 0;
		Queue<Integer> currentLevel = new LinkedList<Integer>();
		currentLevel.add(N);
		while(run && !currentLevel.isEmpty()) {
			currentLevel = bfs(currentLevel);
			count++;
		}
		System.out.println(count);
	}
	
	static Queue<Integer> bfs(Queue<Integer> currentLevel) {
		Queue<Integer> nextLevel = new LinkedList<Integer>();
		while(!currentLevel.isEmpty()) {
			int pos = currentLevel.poll();
			for (int i = 0; i < move.length; i++) {
				int tmp = calc(oper[i], move[i], pos);
				if (tmp < 0 || tmp > 100000 || checked[tmp])
					continue; 
				if (tmp == K)
					return new LinkedList<Integer>();
				checked[tmp] = true;
				nextLevel.add(tmp);
			}
		}
		return nextLevel;
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