import java.util.*;
import java.io.*;

// [15663 N과 M (9)] 

public class Main {
	static StringBuffer sb = new StringBuffer();
	static int n, m;
	static int[] arr;
	static boolean[] visit;
	static int[] res;
	static HashMap<String, Boolean> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visit = new boolean[n];
		res = new int[m];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

//		System.out.println("배열 : " + Arrays.toString(arr));

		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int depth, int start) {
		if (depth == m) {
			
			if(!map.containsKey(Arrays.toString(res))) {
				map.put(Arrays.toString(res), true);
				for (int num : res) {
					sb.append(num).append(" ");
				}
				sb.append("\n");
			}
			
			return; // m개 만큼 뽑으면 Return
		}

		for (int i = 0; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				res[depth] = arr[i];
				dfs(depth + 1, i);
				visit[i] = false;
			}
		}
	}
}
