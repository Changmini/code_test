package baekjoon10.level15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] room;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N+1];
        visited = new boolean[N+1];
        sb = new StringBuilder();
        
        dfs(1);
        System.out.println(sb.toString());
	}
	
	private static void dfs(int number) {
		if (number > M) { // Exit
			for (int n : room) {
				if (n != 0) sb.append(n).append(" ");
			}
			sb.append("\n");
			return ;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true; // 숫자 방문 처리
				room[number] = i; // 숫자 채우기
				dfs(number + 1);
				visited[i] = false;
			}
		}
		
	}
}