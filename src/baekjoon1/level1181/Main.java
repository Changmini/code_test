package baekjoon1.level1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> list = new TreeSet<>((o1, o2) -> {
			int len = o1.length() - o2.length();
			if (len != 0) {
				return len;
			}
			return o1.compareTo(o2);
		});
		
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for(String w : list) {
			sb.append(w).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}