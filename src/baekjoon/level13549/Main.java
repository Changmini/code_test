package baekjoon.level13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        
        Queue<Coordinate> pos = new PriorityQueue<>((o1, o2) -> {
        	return o1.time - o2.time;
        });
        pos.add(new Coordinate(N, 0));
        Coordinate p = null;
		while(!pos.isEmpty()) {
			p = pos.poll();
			
			if (p.x == M)
				break;
			
			if (!visited[p.x])
				visited[p.x] = true;
			
			for (int i = 0; i < 3; i++) {
				int n = 0;
				int t = 0;
				switch(i) {
					case 0: n = p.x - 1; t = 1;
						break;
					case 1: n = p.x + 1; t = 1;
						break;
					case 2: n = p.x * 2; t = 0;
						break;
				}
				
				if (n < 0 || n > 100000 || visited[n])
					continue;
					
				pos.add(new Coordinate(n, p.time + t));
			}
		}
		
		System.out.println(p.time);
	}
	
}

class Coordinate {
	int x;
	int time;
	
	public Coordinate(int x, int time) {
		this.x = x;
		this.time = time;
	}
}