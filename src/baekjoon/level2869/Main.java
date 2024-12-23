package baekjoon.level2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int height = (V - A); // 임계값(V)을 넘기는 순간의 높이를 제외
		int date = 1; // 임계값(V)을 넘기는 순간의 하루(일)
		
		if (height > 0) {
			int distance = A - B; // 이동거리
			date += height / distance;
			
			if (height % distance != 0) // 이동거리보다 작은 거리
				// ex) 조건 A(5) B(1) V(6)일 때,
				//     A가 V를 넘기는 순간, 3의 값을 초과하기에
				//     실제 이동거리(distance = 4)보다 작은 높이(height = 1)가 존재한다
				//     (임계값을 넘기는 순간의 거리를 제외하는 식 때문, **height = V - A)
				//     이것을 해결하기 위해 
				//     이동거리(distance = 4)이하인 높이(height = 1)도 이동 가능한 날짜에 
				//     포함이 되어야 한다.
				date++;
		}
		System.out.println(date);			
	}
	
}