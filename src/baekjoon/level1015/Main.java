package baekjoon.level1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Memory[] A = new Memory[N]; 
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			A[i] = new Memory(v, i);
		}
		
		Arrays.sort(A, (o1, o2) -> o1.value - o2.value);
		
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			P[A[i].index] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(P[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
}

class Memory{
	int value;
	int index;
	
	public Memory(int v, int i) {
		this.value = v;
		this.index = i;
	}
}