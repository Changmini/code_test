package baekjoon1.level2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> list = new TreeSet<>((o1, o2) -> o1 - o2);
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer n : list) {
			sb.append(n).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}