package baekjoon10.level11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int[][] arr = new int[N+1][N+1];
	    for (int row = 1; row <= N; row++) {
	    	st = new StringTokenizer(br.readLine());
	    	for (int col = 1; col <= N; col++) {
				arr[row][col] = arr[row][col-1] + Integer.parseInt(st.nextToken());
			}
		}

	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int row = Integer.parseInt(st.nextToken());
	    	int col = Integer.parseInt(st.nextToken());
	    	int row2 = Integer.parseInt(st.nextToken());
	    	int col2 = Integer.parseInt(st.nextToken());
	    	
	    	int sum = 0;
	    	for (int line = row; line <= row2; line++) {
	    		sum += arr[line][col2] - arr[line][col-1];
			}
	    	sb.append(sum).append("\n");
		}
	    System.out.println(sb.toString());
	}
}
