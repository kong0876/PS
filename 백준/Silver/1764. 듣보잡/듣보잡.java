import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// [1764] 듣보잡
// 

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

		HashMap<String, Boolean> dd = new HashMap<>();
		HashMap<String, Boolean> bd = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dd.put(br.readLine(), true);
		}

		for (int i = 0; i < m; i++) {
			bd.put(br.readLine(), true);
		}

		for (String s : dd.keySet()) {
			if (bd.containsKey(s)) {
				bd.get(s);
				arr.add(s);
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(arr.size());
		for(String s : arr) {
			System.out.println(s);
		}

	}
}