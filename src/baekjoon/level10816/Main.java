package baekjoon.level10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());        
        Map<Integer, Integer> list = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int number = Integer.parseInt(st.nextToken());
        	if (!list.containsKey(number)) {
        		list.put(number, 1);
        		continue;
        	}
        	int cnt = list.get(number);
        	list.put(number, cnt + 1);
		}
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	int number = Integer.parseInt(st.nextToken());
        	Integer cnt = list.get(number);
        	if (cnt == null)
        		sb.append(0).append(" ");
        	else
        		sb.append(cnt).append(" ");
		}
        
        System.out.println(sb.toString());
	}
	
}
