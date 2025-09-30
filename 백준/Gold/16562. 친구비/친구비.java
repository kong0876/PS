import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static int v, w;

	static int[] parent; // 대표
	static int[] cost; // 친구비

	// 루트 찾음
	static int find(int x) {
		if (parent[x] == x)
			return x; // 루트인 경우 반환
		return parent[x] = find(parent[x]); // 아닌 경우 루트 찾으러감
	}

	// 두 집합 합침
	static void union(int a, int b) {
		int ra = find(a); // a의 루트
		int rb = find(b); // b의 루트

		if (ra == rb)
			return; // 이미 같은 집함인 경우 반환

		// 친구비 낮은 애를 루트로
		if (cost[ra] < cost[rb]) {
			parent[rb] = ra;
		} else {
			parent[ra] = rb;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 학생수
		m = Integer.parseInt(st.nextToken()); // 친구 관계 수
		k = Integer.parseInt(st.nextToken()); // 돈

		parent = new int[n + 1];
		cost = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			parent[i] = i; // 초기에는 각자 루트
			cost[i] = Integer.parseInt(st.nextToken()); // 1 ~ n 친구의 친구비
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			union(v, w);
		}

		int res = 0;
		boolean[] counted = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			int r = find(i);
			if (!counted[r]) {
				res += cost[r];
				counted[r] = true;
			}
		}

		if (res > k)
			sb.append("Oh no");
		else
			sb.append(res);

		System.out.print(sb.toString());

	}

}