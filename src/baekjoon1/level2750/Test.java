package baekjoon1.level2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(list);
		
		System.out.println(Arrays.toString(list));
	}

	private static void mergeSort(int[] list) {
		int[] temp = new int[list.length];
		int s = 0;
		int e = list.length - 1;
		int m = (s + e) / 2;
		if (s < e) {
			mergeSort(list, temp, s, m);
			mergeSort(list, temp, m + 1, e);
			merge(list, temp, s, m, e);
		}
	}
	
	private static void mergeSort(int[] list, int[] temp, int s, int e) {
		int start = s;
		int end = e;
		int middle = (start + end) / 2;
		if (start < end) {
			mergeSort(list, temp, start, middle);
			mergeSort(list, temp, middle + 1, end);
			merge(list, temp, start, middle, end);
		}
	}

	private static void merge(int[] list, int[] temp, int start, int middle, int end) {
		int s1 = start;
		int e1 = middle;
		int s2 = middle + 1;
		int e2 = end;
		int idx = start;
		
		while(s1 <= e1 && s2 <= e2) {
			if (list[s1] <= list[s2]) {
				temp[idx++] = list[s1++];
			} else if (list[s1] > list[s2]) {
				temp[idx++] = list[s2++];
			}
		}
		while(s1 <= e1) { temp[idx++] = list[s1++]; }
		while(s2 <= e2) { temp[idx++] = list[s2++]; }
		
		for (int i = start; i <= end; i++) {
			list[i] = temp[i];
		}
	}
	
}













