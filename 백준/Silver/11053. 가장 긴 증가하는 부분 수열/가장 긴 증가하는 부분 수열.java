import java.util.*;
import java.io.*;

// [11053 가장 긴 증가하는 수열] 

public class Main {
	static int n;
	static int[] arr;
	static int[] dp; // i번째 수를 마지막으로 하는 가장 긴 증가 부분 수열 길이
	static int res = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// DP
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					res = Math.max(res,dp[i]);
				}
			}
		}
		
		// Ans
		System.out.println(res);
	}
}
