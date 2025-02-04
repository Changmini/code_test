package baekjoon10.level11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		graph = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			String[] uv = br.readLine().split(" ");
			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);
			graph[u][v] = true;
			graph[v][u] = true;
		}
		
		visited = new boolean[N + 1];
		int elementCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!check(i))
				continue;
			elementCnt++;
		}
		System.out.println(elementCnt);
	}
	
	static boolean check(int idx) {
		if (visited[idx])
			return false;
		visited[idx] = true;
		for (int j = 1; j <= N; j++) {
			if (idx==j || !graph[idx][j])
				continue;
			check(j);
		}
		return true;
	}
	
}