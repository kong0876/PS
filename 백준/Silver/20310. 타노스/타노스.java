import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();
		
		int zero = 0;
		int one = 0;

		String input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			int cur = input.charAt(i) - '0';

			if (cur == 0)
				zero++;
			else
				one++;
			
			arr.add(cur);
		}

		zero = zero / 2;
		one = one /2 ;
		
//		System.out.println("zero : " + zero + ", one : " + one);
//		System.out.println("before : " + arr);
		
		
		// 0은 뒤에서부터 제거
		for (int i = arr.size() - 1; i >= 0; i--) {
			if(zero == 0) break;
			if(arr.get(i) == 0) {
				arr.remove(i);
				zero--;
			}
		}
		
		// 1은 앞에서부터 제거
		for (int i = 0; i < arr.size(); i++) {
			if(one == 0) break;
			if(arr.get(i) == 1) {
				arr.remove(i);
				one--;
				i--;
			}
		}

//		System.out.println("after : " + arr);
		
		for(int i : arr) {
			sb.append(i);
		}

		System.out.println(sb);

	}
}