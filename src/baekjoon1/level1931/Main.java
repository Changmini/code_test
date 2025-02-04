package baekjoon1.level1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] list = new Meeting[N];
		for (int i = 0; i < N; i++) {
			String[] se = br.readLine().split(" ");
			int start = Integer.parseInt(se[0]);
			int end = Integer.parseInt(se[1]);
			list[i] = new Meeting(start, end);
		}
		
		Arrays.sort(list);
		
		int eTime = list[0].getEndTime();
		int count = 1;
		for (int i = 1; i < N; i++) {
			int e = list[i].getEndTime();
			int s = list[i].getStartTime();
			
			if (eTime <= s) {
				count++;
				eTime = e;
			}
		}
		System.out.println(count);
	}
	
}

class Meeting implements Comparable<Meeting> {
	int startTime;
	int endTime;
	
	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	@Override
	public int compareTo(Meeting o) {
		if (endTime < o.getEndTime())
			return -1;
		else if (endTime > o.getEndTime())
			return 1;
		else {
			if (startTime < o.getStartTime())
				return -1;
			else if (startTime > o.getStartTime())
				return 1;
			else 
				return 0;
		}
	}
}