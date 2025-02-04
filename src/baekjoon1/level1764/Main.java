package baekjoon1.level1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> m = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			m.add(name);
		}
		
		Set<String> answer = new TreeSet<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (!m.contains(name))
				continue;
			answer.add(name);
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (String name : answer) {
			count++;
			sb.append(name).append("\n");
		}
		System.out.println(count + "\n" + sb.toString());
	}
	
}
