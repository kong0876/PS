import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		String input = br.readLine();
		
		sb.append(input);
		int len = input.length();

		int start = 0;
		
		while(true) {
			if(isPal(input.substring(start))) {
				break;
			}
			
			start ++;
		}
		
		System.out.println(len + start);

	}

	static boolean isPal(String s) {

		int sLen = s.length();
		int mid = (sLen - 1) / 2;

		for (int i = 0; i <= mid; i++) {
			if (s.charAt(i) != s.charAt((sLen - 1) - i)) {
				return false;
			}
		}

		return true;
	}
}