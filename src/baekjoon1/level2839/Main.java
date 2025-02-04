package baekjoon1.level2839;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int x = (N / 5);
		int y = (N / 3);
		int a = 0;
		int b = 0;
		boolean res = false;
		for (int i = x; i >= 0; i--) {
			for (int j = y; j >= 0; j--) {
				a = 5 * i;
				b = 3 * j;
				res = (N == a + b); 
				if (res) {
					x = i;
					y = j;
					break;
				}
			}
			if (res) {
				break;
			}
		}
		System.out.println(res ? x+y : -1);
	}
	
}