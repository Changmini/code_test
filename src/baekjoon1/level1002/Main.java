package baekjoon1.level1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int T = Integer.parseInt(br.readLine());
        Calc[] c = new Calc[T];
        for (int i=0; i < T; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int r1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	int r2 = Integer.parseInt(st.nextToken());
        	c[i] = new Calc(x1, y1, r1, x2, y2, r2);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < T; i++) {
        	sb.append(c[i].run()).append("\n");
        }
        System.out.println(sb.toString());
	}
}
class Calc {
	int x1;
	int y1;
	int r1;
	int x2;
	int y2;
	int r2;
	
	public Calc (int x1, int y1, int r1, int x2, int y2, int r2) {
		this.x1 = x1;
		this.y1 = y1;
		this.r1 = r1;
        this.x2 = x2;
        this.y2 = y2;
        this.r2 = r2;
	}
	
	public int run(){
		double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		int r = r1 + r2;
		int minR = Math.min(r1, r2);
		int maxR = Math.max(r1, r2);
		double dwm = distance + minR;
		if (distance == 0 && r1 == r2) {
			return -1;
		} else if (distance > r || (distance == 0 && r1 != r2) || dwm < maxR) {
			return 0;
		} else if(distance == r || dwm == maxR) {
			return 1;
		} else {
			return 2;
		}
	}
}