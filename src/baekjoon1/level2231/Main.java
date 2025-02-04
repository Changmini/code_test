package baekjoon1.level2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int tmp = 0; tmp < N; tmp++) {
			int sumRemainder = tmp % 10;
			int quotient = tmp / 10;
			while(quotient > 0) {
				sumRemainder += quotient % 10;
				quotient = quotient / 10;
			}
			if (sumRemainder + tmp == N) {
				answer = tmp;
				break;
			}
		}
		System.out.println(answer);
	}
	
}