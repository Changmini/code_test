package baekjoon.level1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] farm;
	static boolean[][] visited;
	static int M;
	static int N;
	static int[] moveY = {-1, 0, 1, 0};
	static int[] moveX = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	farm = new int[N+1][M+1];
        	visited = new boolean[N+1][M+1];

        	int K = Integer.parseInt(st.nextToken());
	        for (int j = 0; j < K; j++) {
	        	st = new StringTokenizer(br.readLine());
	        	int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1;
			}
	        
	        int count = 0;
	        for (int y = 0; y <= N; y++) {
	        	for (int x = 0; x <= M; x++) {
	        		if (dfs(y, x))
	        			count++;
	        	}
			}
	        
	        sb.append(count).append("\n");
        }
        
        System.out.println(sb.toString());
	}

	private static boolean dfs(int y, int x) {
		if (y < 0 || x < 0 || y > N || x > M
				|| farm[y][x] == 0 || visited[y][x])
			return false;
		
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			dfs(y + moveY[i], x + moveX[i]);
		}
		
		return true;
	}
}