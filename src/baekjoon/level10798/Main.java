package baekjoon.level10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        char[][] word = new char[5][];
        int max = 0;
        for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			char[] w = st.nextToken().toCharArray();
			word[i] = new char[w.length];
			if (max < w.length)
				max = w.length;
			for (int j = 0; j < w.length; j++) {
				word[i][j] = w[j];
			}
		}
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (word[j].length <= i) 
					continue;
				sb.append(word[j][i]);
			}
		}
        
        System.out.println(sb.toString());
	}
	
}