package baekjoon1.level2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] tree = new long[N];
		long max = 0L;
		long min = 0L;
		for (int i = 0; i < N; i++) {
			tree[i] = Long.valueOf(st.nextToken());
			if (max < tree[i])
				max = tree[i];
		}
		
		while(min < max) {
			long H = (max + min) / 2;
			long m = 0;
			for (int i = 0; i < tree.length; i++) {
				long n = tree[i] - H;
				m += n > 0 ? n : 0;
			}
			
			if (M <= m) {
				min = H + 1;
			} else {
				max = H;
			}
		}
		System.out.println(min - 1);
	}
	
}