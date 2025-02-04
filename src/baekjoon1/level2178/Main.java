package baekjoon1.level2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] yAxes = {-1, 0, 1, 0};
	static int[] xAxes = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];
        
        for (int y = 1; y <= N; y++) {
        	String line = br.readLine();
        	for (int s=0, x = 1; x <= M;x++) {
        		miro[y][x] = Integer.parseInt(line.substring(s++, x));
			}
		}
        
        Queue<Position> list = new PriorityQueue<>(
        		(o1, o2) -> o1.distance - o2.distance);
        list.add(new Position(1, 1, 1));
        Position p = null;
        while(!list.isEmpty()) {
        	p = list.poll();
        	
        	if (p.y == N && p.x == M)
        		break;
        	
        	if (visited[p.y][p.x])
        		continue;
        	else 
        		visited[p.y][p.x] = true; 
        	
        	int nY = 0;
        	int nX = 0;
        	for(int i=0; i < 4; i++) {
        		nY = p.y + yAxes[i];
        		nX = p.x + xAxes[i];
        		
        		if (1 > nY || nY > N || 1 > nX || nX > M
        				|| miro[nY][nX] == 0 || visited[nY][nX])
        			continue;
        		
        		list.add(new Position(nY, nX, p.distance + 1));
        	}// for	
        }// while
        System.out.println(p.distance);
	}
	
}
class Position {
	int y;
	int x;
	int distance;
	
	public Position(int y, int x, int distance) {
		this.y = y;
		this.x = x;
		this.distance = distance;
	}
}
