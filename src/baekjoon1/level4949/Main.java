package baekjoon1.level4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> memory = new Stack<Character>();
        String text = br.readLine();
        while(!text.equals(".")) {
        	char[] e = text.toCharArray();
        	
        	for (int i = 0; i < e.length; i++) {
        		if (e[i] != '(' && e[i] != '[' && e[i] != ')' && e[i] != ']')
        			continue;
        		
				if (e[i] == '(' || e[i] == '[') {
					memory.add(e[i]);
					continue;
				}
				
				if ((e[i] == ')' || e[i] == ']') && memory.isEmpty()) {
        			memory.add('N');
					break;
				}
				
				char tmp = memory.peek();
				if ((tmp == '(' && e[i] == ')') || (tmp == '[' && e[i] == ']'))
					memory.pop();
				else 
					break;
			}
        	
        	if (memory.isEmpty())
        		sb.append("yes").append("\n");
        	else 
        		sb.append("no").append("\n");
        	
        	memory.clear();
        	text = br.readLine();
        }
        
        System.out.println(sb.toString());
	}
}