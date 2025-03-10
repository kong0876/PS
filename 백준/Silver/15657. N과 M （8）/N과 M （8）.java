import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> arr;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = new int[m];
		
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		while (st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);

		dfs(0, 0); // 중복 가능 조합 -> start 필요, visit 불필요
		System.out.println(sb);
	}

	static void dfs(int depth, int start) {
		if (depth == m) {
			for (int val : res) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.size(); i++) {
			res[depth] = arr.get(i);
			dfs(depth + 1, i);
		}
	}
}