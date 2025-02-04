package baekjoon1.level2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Integer dp[];
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1] = arr[1];
		
		if(N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		System.out.println(find(N));
		
	}
	
	static int find(int N) {
		// 아직 탐색하지 않는 N번째 계단일 경우
		if(dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}
		
		return dp[N];
	}
	
	// 내가 풀었던 방식
//	static int result = 0;
//	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] list = new int[n];
//		for (int i = 0; i < n; i++) {
//			list[i] = sc.nextInt();
//		}
//		depthFirstSearch(list);
//		System.out.println(result);
//	}
//	private static void depthFirstSearch(int[] list) {
//		if (list.length > 0)
//			depthFirstSearch(list, 1, 1, list[0]);
//		if (list.length > 1) 
//			depthFirstSearch(list, 2, 1, list[1]);
//	}
//	private static void depthFirstSearch(int[] list, int curr, int level, int sum) {
//		if (list.length <= curr || level >= 2)
//			return ;
//		sum = sum + list[curr];
//		if (list.length - 1 == curr && result < sum) {
//			result = sum;
//			return ;
//		}
//		depthFirstSearch(list, curr + 1, level+1, sum);
//		depthFirstSearch(list, curr + 2, 0, sum);
//	}
	
}



