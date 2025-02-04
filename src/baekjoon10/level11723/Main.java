package baekjoon10.level11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        
        Cset S = new Cset();
        int value = 0;
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	String command = st.nextToken();
        	
        	switch (command) {
			case "add":
				value = Integer.parseInt(st.nextToken());
				S.add(value); break;
			case "remove":
				value = Integer.parseInt(st.nextToken());
				S.remove(value); break;
			case "check":
				value = Integer.parseInt(st.nextToken());
				sb.append(S.check(value)).append("\n"); break;
			case "toggle":
				value = Integer.parseInt(st.nextToken());
				S.toggle(value); break;
			case "all":
				S.all(); break;
			case "empty":
				S.empty(); break;
			default: break;
			}
        	
		}
        
        System.out.println(sb.toString());
	}
	
}

class Cset {
	private HashSet<Integer> list;
	private List<Integer> init;
	
	public Cset() {
		list = new HashSet<Integer>();
		init = (List<Integer>) Arrays.asList(
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
		);
	}
	
	public void add(Integer value) {
		if (list.contains(value)) {
			return ;
		}
		list.add(value);
	}
	
	public void remove(Integer value) {
		if (!list.contains(value)) {
			return ;
		}
		list.remove(value);
	}
	
	public int check(Integer value) {
		return list.contains(value) ? 1 : 0;
	}
	
	public void toggle(Integer value) {
		if (list.contains(value)) {
			list.remove(value);
		} else {
			list.add(value);
		}
	}
	
	public void all() {
		list = new HashSet<Integer>(init);
	}
	
	public void empty() {
		list.clear();
	}
}