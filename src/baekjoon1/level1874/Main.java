package baekjoon1.level1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		int pre = 1;
		int next = 0;
		int i = 0;
		while(true) {
			
			if (!s.isEmpty() && next == s.peek()) {
				s.pop();
				sb.append("-").append("\n");
				continue;
			}
			
			if (i == n)
				break;
			
			next = Integer.parseInt(br.readLine());
			i++;
			
			for (int j = pre; j <= next; j++) {
				s.push(j);
				sb.append("+").append("\n");
			}
			
			if (pre <= next)
				pre = next + 1;
		}
		
		System.out.println(s.isEmpty() ? sb.toString() : "NO");
	}
	
}