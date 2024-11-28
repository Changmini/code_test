package baekjoon.level1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int command = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());

			if (command == 0) {
				union(a, b);
			} else {
				if (isSameParent(a, b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
        System.out.println(sb.toString());
	}
	
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
 
        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
	
    public static int find(int element) {
        if (element == parent[element]) {
            return element;
        }
        return parent[element] = find(parent[element]);
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x == y) {
            return true;
        }
 
        return false;
    }
}