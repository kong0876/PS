import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N + 1];

		backtrack(1, 0);
	}

	static void backtrack(int start, int depth) {
		if (depth == M) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			backtrack(i + 1, depth + 1);
		}
	}
}