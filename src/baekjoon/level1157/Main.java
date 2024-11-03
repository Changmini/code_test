package baekjoon.level1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toUpperCase().toCharArray();
		
		int[] list = new int[91]; 
		for (int i = 0; i < word.length; i++) {
			char w = word[i];
			list[(int) w] = list[(int) w] + 1;
		}
		
		int dupl = 0;
		int answerCnt = 0;
		String answer = "";
		for (int i = 65; i < list.length; i++) {
			int cnt = list[i];
			if (answerCnt < cnt) {
				dupl = 0;
				answerCnt = cnt;
				answer = String.valueOf((char) i);
			} else if (answerCnt == cnt) {
				dupl++;
			}
		}
		System.out.println(dupl > 0 ? "?" : answer);
	}
}