package baekjoon.level2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] height;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		height = new int[9];
		select = new boolean[9];
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(height);
		
		for (int i = 0; i < height.length; i++) {
			if (!dfs(i, 0, 1))
				continue;
			select[i] = true;
			break;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < select.length; i++) {
			if (select[i])
				sb.append(height[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean dfs(int idx, int sum, int cnt) {
		if (cnt > 7)
			return false;
		
		sum = sum + height[idx];
		if (sum == 100 && cnt == 7)
			return true;
		
		for (int i = idx + 1; i < height.length; i++) {
			if (dfs(i, sum, cnt + 1)) {
				return select[i] = true;
			}
		}
		
		return false;
	}
	
}