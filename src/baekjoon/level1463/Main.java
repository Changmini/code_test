package baekjoon.level1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		
		Integer[] number = new Integer[N+1];
		
		number[0] = number[1] = 0;
		
		System.out.println(search(number, N));
	}

	private static int search(Integer[] number, int n) {
		if (number[n] != null)
			return number[n];
		
		if (n % 6 == 0) {
			number[n] = Math.min(search(number, n / 3), 
					Math.min(search(number, n / 2), search(number, n - 1))) + 1;
		} else if (n % 3 == 0) {
			number[n] = Math.min(search(number, n / 3), search(number, n - 1)) + 1;
		} else if (n % 2 == 0) {
			number[n] = Math.min(search(number, n / 2), search(number, n - 1)) + 1;
		} else {
			number[n] = search(number, n - 1) + 1;
		}
		
		return number[n];
	}
 
}