package baekjoon1.level1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean[] list = new boolean[128];
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] word = st.nextToken().toCharArray();
			boolean check = true;
			list = new boolean[128];
			
			char bef = word[0];
			for (int j = 1; j < word.length; j++) {
				int idx = (int) word[j];
				if (list[idx]) {
					check = false;
					break;
				}
				if (bef != word[j]) {// 새로운 단어
					int preIdx = (int) bef;
					list[preIdx] = true;
					bef = word[j];
				}
			}
			
			if (check)
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
}