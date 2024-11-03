package baekjoon.level12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		Queue<Integer> mainWay = new LinkedList<>();
		Stack<Integer> sideWay = new Stack<>();
		String[] students = br.readLine().split(" ");
		for (int i=0; i<count; i++) {
			mainWay.add(Integer.parseInt(students[i]));
		}
		
		int order = 1;
		Integer student = null;
		while(!mainWay.isEmpty()) {
			student = mainWay.peek();
			if (student != null && student == order) {
				order++;
				mainWay.poll();
			} else {
				int tmp = order;
				while(!sideWay.isEmpty()) {
					student = sideWay.peek();
					if (student != null && student == order) {
						order++;
						sideWay.pop();
					} else {
						break;
					}
				}
				if (tmp == order) {
					sideWay.add(mainWay.poll());
				}
			}
		}
		while(!sideWay.isEmpty()) {
			student = sideWay.peek();
			if (student != null && student == order) {
				order++;
				sideWay.pop();
			} else {
				break;
			}
		}
		
		System.out.println(mainWay.isEmpty() && sideWay.isEmpty() ? "Nice" : "Sad");
	}
}