import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

// [11478] 서로 다른 부분 문자열

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		HashSet<String> set = new HashSet<>();
		
		for (int sLen = 1; sLen <= s.length(); sLen++) {
			for (int start = 0; start < s.length() - sLen + 1; start++) {
				StringBuilder sb = new StringBuilder();
				for(int cur = start; cur <= start + sLen - 1; cur ++) {
					sb.append(s.charAt(cur));
				}
				set.add(sb.toString());
			}
		}
		
		System.out.println(set.size());

	}
}