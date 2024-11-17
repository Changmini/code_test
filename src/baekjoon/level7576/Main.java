package baekjoon.level7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] box = new int[N][M];
        Queue<Tomato> grow = new LinkedList<>();
        for (int y = 0; y < N; y++) {
        	st = new StringTokenizer(br.readLine());
        	for (int x = 0; x < M; x++) {
        		box[y][x] = Integer.parseInt(st.nextToken());
        		if (box[y][x] == 1)
        			grow.add(new Tomato(x, y, 0));
    		}
		}
        
        int[] width = {0, +1, 0, -1};
        int[] height = {-1, 0, +1, 0};
        int max = 0;
        while(!grow.isEmpty()) {
        	Tomato t = grow.poll();
        	
        	if (t.day > max)
        		max = t.day;
        	
    		for (int i = 0; i < 4; i++) {
				int x = t.x + width[i];
				int y = t.y + height[i];
				if (0 > x || x >= M  || 0 > y || y >= N)
					continue;
				int condition = box[y][x];
				if (condition == 1 || condition == -1)
					continue;
				box[y][x] = 1;
				grow.add(new Tomato(x, y, t.day + 1));
			}
        }
        
        boolean check = true;
        for (int y = 0; y < box.length; y++) {
        	for (int x = 0; x < box[y].length; x++) {
    			if (box[y][x] != 0)
    				continue;
    			check = false;
    			break;
    		}			
        	if (!check) break;
		}
        System.out.println(check ? max : -1);
	}
	
}

class Tomato {
	int x;
	int y;
	int day;
	
	public Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}