package baekjoon.level25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        Map<String, Double> grades = new HashMap<>() {{
        	put("A+", 4.5);
        	put("A0", 4.0);
        	put("B+", 3.5);
        	put("B0", 3.0);
        	put("C+", 2.5);
        	put("C0", 2.0);
        	put("D+", 1.5);
        	put("D0", 1.0);
        	put("F", 0.0);
        }};
        
        double sum = 0.0;
        float total = 0;
        for (int i = 0; i < 20; i++) {
        	st = new StringTokenizer(br.readLine());
        	st.nextToken();
        	float score = Float.parseFloat(st.nextToken());
        	String grade = st.nextToken();
        	if (!grades.containsKey(grade))
        		continue;
        	double level = grades.get(grade);
        	sum += score * level;
        	total += score;
		}
        System.out.println(sum / total);
	}
	
}