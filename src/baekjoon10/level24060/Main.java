package baekjoon10.level24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int ANSWER = -1;
	static int COUNT = 0;
	static int ARR_COUNT = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int len = Integer.parseInt( input[0] );
		ARR_COUNT = Integer.parseInt( input[1] );
		
		String[] num = br.readLine().split(" ");
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
		mergeSort(arr);
		System.out.println(ANSWER);
	}
	
	public static void mergeSort(int[] arr) {
		int s = 0;
		int e = arr.length-1;
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, s, e);
	}
	public static void mergeSort(int[] arr, int[] temp, int s, int e) {
		int m = (s + e) / 2;
		if (s < e) {
			mergeSort(arr, temp, s, m);
			mergeSort(arr, temp, m+1, e);
			merge(arr, temp, s, m, e);
		}
	}
	public static void merge(int[] arr, int[] temp, int s, int m, int e) {
		int i = s;
		int j = m+1;
		int tempIdx = s;
		while(i <= m && j <= e) {
			if (arr[i] <= arr[j]) {
				temp[tempIdx] = arr[i++];
				COUNT++;
				if (COUNT == ARR_COUNT) {
					ANSWER = temp[tempIdx];
				}
				tempIdx++;
			}
			if (arr[j] < arr[i]) {
				temp[tempIdx] = arr[j++];
				COUNT++;
				if (COUNT == ARR_COUNT) {
					ANSWER = temp[tempIdx];
				}
				tempIdx++;
			}
			
		}
		
		while(i <= m) {
			temp[tempIdx] = arr[i++];
			COUNT++;
			if (COUNT == ARR_COUNT) {
				ANSWER = temp[tempIdx];
			}
			tempIdx++;
		}
		while(j <= e) {
			temp[tempIdx] = arr[j++];
			COUNT++;
			if (COUNT == ARR_COUNT) {
				ANSWER = temp[tempIdx];
			}
			tempIdx++;
		}
		
		for (int k = s; k <= e; k++) {
			arr[k] = temp[k];
		}
	}
}