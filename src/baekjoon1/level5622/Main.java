package baekjoon1.level5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] time = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int res = 0;
		char[] alphabet = st.nextToken().toCharArray();
		for (int i = 0; i < alphabet.length; i++) {
			char a = alphabet[i];
			res += time[searchNumber(a)];
		}
		
		System.out.println(res);
	}
	
	public static int searchNumber(char alphabet) {
		int number = 0;
		switch(alphabet) {
			case 'A': case 'B': case 'C':
				number = 2;
				break;
			case 'D': case 'E': case 'F':
				number = 3;
				break;
			case 'G': case 'H': case 'I':
				number = 4;
				break;
			case 'J': case 'K': case 'L':
				number = 5;
				break;
			case 'M': case 'N': case 'O':
				number = 6;
				break;
			case 'P': case 'Q': case 'R': case 'S':
				number = 7;
				break;
			case 'T': case 'U': case 'V':
				number = 8;
				break;
			case 'W': case 'X': case 'Y': case 'Z':
				number = 9;
				break;
			default: break;
		}
		return number;
	}
	
}