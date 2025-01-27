package baekjoon.level15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] word = br.readLine().toCharArray();
		long answer = 0L;
		for (int i = 0; i < N; i++) {
			int num = word[i] - 96;
			answer += num * Math.pow(31, i);
		}
		System.out.println(answer);
	}
	
}