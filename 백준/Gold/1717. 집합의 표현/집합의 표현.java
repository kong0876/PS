import java.util.*;
import java.io.*;

// [1717 집합의 표현] 

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 0~n인 n+1개의 집합
		m = Integer.parseInt(st.nextToken()); // m개의 연산 입력
		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) { // m개의 연산 입력
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (com == 0) { // a의 집합 + b의 집합
				union(a, b);
			} else if (com == 1) { // a,b가 같은 집합이면 YES, 아니면 NO
				if (find(a) == find(b)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void union(int a, int b) { // 두개의 집합을 루트를 기준으로 합침
		int rootA = find(a); 
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootB] = rootA;
		}
		
//		System.out.println(Arrays.toString(parent));
	}

	private static int find(int x) { // Root 노드 확인
		if(x!=parent[x]) {
			parent[x] = find(parent[x]);
		}
		
		
		return parent[x];
	}
}
