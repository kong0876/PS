import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// a를 b번 곱한 수를 c로 나눈 나머지 = a^b%c
		
		System.out.println(func(a,b,c));
		
		
	}
	
	static long func(int a, int b, int c) {
		
		if(b == 1) { 
			return a % c;
		}
		
		long val = func(a, b/2, c);
		val = val * val % c;
		if(b % 2 == 0)  // 짝수 제곱인 경우
			return val;
		return val * a % c;
		
	}
}
