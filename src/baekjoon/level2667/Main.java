package baekjoon.level2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int[] yPos = {-1, 0, 1, 0};
	static int[] xPos = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        int[][] pan = new int[N][N];
        for (int y = 0; y < N; y++) {
        	char[] line = br.readLine().toCharArray();
        	for (int x = 0; x < N; x++) {
        		pan[y][x] = line[x] == '0' ? 0 : 1;
			}
		}
        
        boolean[][] visited = new boolean[N][N];
        List<Integer> apart = new ArrayList<>();
        int apartComplex = 0;
        int temp = 0;
        for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if ((temp = dfs(pan, visited, y, x)) == 0)
					continue;
				apart.add(temp);
				apartComplex++;	
			}
		}
        
        Collections.sort(apart, (o1, o2) -> o1 - o2);
        
        StringBuilder sb = new StringBuilder();
        sb.append(apartComplex).append("\n");
        for(Integer n : apart) {
        	sb.append(n).append("\n");
        }
        System.out.println(sb.toString());
	}

	static int dfs(int[][] pan, boolean[][] visited, int y, int x) {
		if (0 > y|| pan.length <= y 
				|| 0 > x|| pan[y].length <= x
				|| pan[y][x] == 0 || visited[y][x])
			return 0;
		
		visited[y][x] = true;
		
		int sum = pan[y][x];
		for (int i = 0; i < 4; i++) {
			int ny = y + yPos[i];
			int nx = x + xPos[i];
			sum += dfs(pan, visited, ny, nx);
		}
		return sum;
	}
	
}
