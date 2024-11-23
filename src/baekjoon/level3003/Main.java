package baekjoon.level3003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int[] origin = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < origin.length; i++) {
        	 int num = Integer.parseInt(st.nextToken());
        	 sb.append(origin[i] - num).append(" ");
		}
        System.out.println(sb.toString());
	}
	
}