package baekjoon1.level2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int result = list.poll();
		boolean pattern = true;
		while(!list.isEmpty()) {
			
			if (!pattern) {
				list.add(result);
			}
			
			pattern = !pattern;
			
			result = list.poll();
		}
		
		System.out.println(result);
 
	}
 
}