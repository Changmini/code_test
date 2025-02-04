package baekjoon10.level10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		List<Member> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(i, age, name));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(Member m : list) {
			sb.append(m.age + " " + m.name).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}

class Member implements Comparable<Member> {
	int seq;
	int age;
	String name;
	
	public Member(int seq, int age, String name) {
		this.seq = seq;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Member o) {
		if (this.age > o.age)
			return 1;
		else if (this.age < o.age)
			return -1;
		else {
			return seq - o.seq;
		}
	}	
}