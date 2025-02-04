package baekjoon1.level1427;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		char[] number = sc.next().toCharArray();
		int size = number.length;
		int[] list = new int[size]; 
		for (int i = 0; i < size; i++) {
			list[i] = Integer.parseInt(String.valueOf(number[i]));
		}
		Arrays.sort(list);
		for (int i = list.length-1; i >= 0; i--) {
			System.out.print(list[i]);		
		}
		
	}
	
}