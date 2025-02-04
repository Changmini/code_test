package baekjoon1.level9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(st.nextToken());
        Stack<Character> memo = new Stack<Character>();
        for (int i = 0; i < T; i++) {
        	char[] text = br.readLine().toCharArray();
        	
        	for (char t : text) {
				if (t == '(') {
					memo.add(t);
				} else if (!memo.isEmpty() && memo.peek() == '(') {
					memo.pop();
				} else {
					memo.add('N');
					break;
				}
			}
        	
        	if (memo.isEmpty()) {
        		sb.append("YES").append("\n");
        	} else {
        		sb.append("NO").append("\n");
        	}
        	memo.clear();
		}
        
        System.out.println(sb.toString());
	}
}