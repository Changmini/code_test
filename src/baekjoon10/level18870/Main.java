package baekjoon10.level18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int[] list = new int[N];
        int[] sorted = new int[N];
        for (int i = 0; i < N; i++) {
        	list[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(sorted);
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < sorted.length; i++) {
        	if (map.containsKey(sorted[i]))
        		continue ;
			map.put(sorted[i], count++);
		}
        
        for (int i = 0; i < list.length; i++) {
			sb.append(map.get(list[i])).append(" ");
		}
        
        System.out.println(sb.toString());
	}
	
}