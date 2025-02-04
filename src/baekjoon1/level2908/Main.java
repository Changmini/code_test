package baekjoon1.level2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		String[] input = br.readLine().split(" ");
		int[] number = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			int size = input[i].length() - 1;
			sb = new StringBuilder();
			for (int j = size; j >= 0; j--) {
				sb.append(input[i].charAt(j));
			}
			number[i] = Integer.parseInt(sb.toString());
		}
		System.out.println(Math.max(number[0], number[1]));
	}
	
}