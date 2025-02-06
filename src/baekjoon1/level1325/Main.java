package baekjoon1.level1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] computer = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			computer[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int children = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			computer[parent].add(children);
		}
		
		boolean[] visited = null;
		Queue<Integer> list = new LinkedList<>();
		int[] cnt = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			
			list.add(i);
			visited[i] = true;
			while(!list.isEmpty()) {
				Integer cn = list.poll();
				
				for (Integer n : computer[cn]) {
					if (visited[n]) continue;
					visited[n] = true;
					list.add(n);
					cnt[i]++;
				}
			}
			
			if (max < cnt[i]) max = cnt[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (max == cnt[i]) sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}