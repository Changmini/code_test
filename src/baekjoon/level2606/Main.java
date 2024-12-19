package baekjoon.level2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Computer {
	private List<Integer> connComputers;
	
	public Computer() {
		this.connComputers = new ArrayList<>();
	}
	
	public void add(int vertex) {
		this.connComputers.add(vertex);
	}
	
	public List<Integer> getOthers() {
		return connComputers;
	}
}

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        int CC = Integer.parseInt(br.readLine());
        boolean run = CC > 0;
        
        Computer[] cp = new Computer[C + 1];
        StringTokenizer st = null;
		for (int i = 0; i < CC; i++) {
			st = new StringTokenizer(br.readLine());
	        int v1 = Integer.parseInt(st.nextToken());
	        int v2 = Integer.parseInt(st.nextToken());
	        if (cp[v1] == null)
	        	cp[v1] = new Computer();
	        if (cp[v2] == null)
	        	cp[v2] = new Computer();
	        cp[v1].add(v2);
	        cp[v2].add(v1);
		}
		
		boolean[] visited = new boolean[C + 1];
		int count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		if (run)
			q.add(1);
		while (!q.isEmpty()) {
			int v = q.poll();
			
			if (visited[v])
				continue;
			
			visited[v] = true;
			count++;
			
			List<Integer> next = cp[v].getOthers();
			for(Integer i : next) {
				if (visited[i])
					continue;
				q.add(i);
			}
		}
        
		System.out.println(run ? count - 1 : 0);
    }
}