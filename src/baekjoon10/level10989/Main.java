package baekjoon10.level10989;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		int[] sortArr = new int[10001];
		for (int i = 0; i < num; i++) {
			sortArr[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i < sortArr.length; i++) {
			int cnt = sortArr[i];
			for (int j = 0; j < cnt; j++) {
				sb.append(i).append("\n");	
			}
		}
		System.out.print(sb.toString());
	}
	
}