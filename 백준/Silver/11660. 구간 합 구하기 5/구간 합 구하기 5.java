import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 표의 크기
		int m = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수

		int[][] arr = new int[n + 1][n + 1];

		for (int row = 1; row <= n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 1; col < n + 1; col++) {
				arr[row][col] = arr[row][col - 1] + arr[row - 1][col] - arr[row - 1][col - 1]
						+ Integer.parseInt(st.nextToken());
			}
		}


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			System.out.println(
					arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1 -1][y1 - 1]
					);
		}
	}

}
