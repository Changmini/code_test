package baekjoon1.level1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int befLanCnt = Integer.parseInt(input[0]);
		int aftLanCnt = Integer.parseInt(input[1]);
		int[] list = new int[befLanCnt];
		long high = 0;
		for (int i = 0; i < befLanCnt; i++) {
			list[i] = Integer.parseInt(br.readLine());
			if(high < list[i]) {
				high = list[i];
			}
		}
 
		high++; 
		long low = 0; 
		long lanLength = 0; 
		int count = 0;
		while (low < high) {
			count = 0;
			lanLength = (high + low) / 2;
			for (int i = 0; i < list.length; i++) {
				count += (list[i] / lanLength);
			}
			
			if(count < aftLanCnt) {
				high = lanLength;
			} else {
				low = lanLength + 1;
			}
		}
		
		System.out.println(low - 1);
	}
}