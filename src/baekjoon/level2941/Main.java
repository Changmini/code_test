package baekjoon.level2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] twoToken = {"c=","c-","d-","lj","nj","s=","z="};
		String threeToken = "dz=";
		
		String word = br.readLine();
		int over = word.length();
		String part = null;
		boolean ch1 = false;
		boolean ch2 = false;
		int cnt = 0;
		int i = 0;
        while(i < over) {
        	
        	if (i + 1 < over) {
	        	part = word.substring(i, i+2);
	        	for (int j = 0; j < twoToken.length; j++) {
					if (!twoToken[j].equals(part))
						continue;
					i = i + 2;
					cnt++;
					ch1 = true;
					break;	
				}
        	}
        	
        	if (i + 2 < over) {
	        	part = word.substring(i, i+3);
	        	if (threeToken.equals(part)) {
	        		i = i + 3;
	        		cnt++;
	        		ch2 = true;
	        		continue;
	        	}
        	}
        	
        	if (!ch1 && !ch2) {
	        	cnt++;
	        	i++;
        	}
        	ch1 = false;
        	ch2 = false;
        }
        
        System.out.println(cnt);
	}
}