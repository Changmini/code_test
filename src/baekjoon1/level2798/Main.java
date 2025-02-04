package baekjoon1.level2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		int[] list = new int[N];
 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		boolean run = true;
		for (int i = 0; i < N - 2; i++) {
			if(list[i] > M) continue;
			
			for (int j = i + 1; j < N - 1; j++) {
				int sum2 = list[i] + list[j];
				if(sum2 > M) continue;
				
				for (int k = j + 1; k < N; k++) {
					int sum3 = sum2 + list[k];
					if(sum3 > M) continue;
					 
					if (M == sum3) {	
						res = sum3;
						run = false;
						break;
					}
					 
					if(res < sum3) {
						res = sum3;
					}
				}
				if (!run) break;
			}
			if (!run) break;
		}
		
		System.out.println(res);
	}
	
}