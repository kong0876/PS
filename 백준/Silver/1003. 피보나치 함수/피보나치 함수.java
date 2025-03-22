import java.util.*;
import java.io.*;

// [1003] 피보나치 함수
public class Main {
	static int t, n;
	static int dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			dp = new int[n + 1][2];
			dp[0][0] = 1;
			if(n>=1) {
				dp[1][1] = 1;				
			}
			
			fibo(n);
			

			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}

	static int[] fibo(int n) {
		
		if(n >= 1) {			
			if(dp[n][0] == 0 && dp[n][1] == 0) { // dp 테이블이 안채워진 경우
				dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
				dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
			}
		}
		
		return dp[n];
	}
}
