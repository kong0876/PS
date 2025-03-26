import java.io.*;
import java.util.*;

// [11724 연결 요소의 개수]
// 시간 :  / 메모리 : 

public class Main {

	static int n, m;
	static int u, v;
	static boolean[] visited;
	static ArrayList<Integer>[] conn;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 정점의 개수
		m = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		conn = new ArrayList[n + 1]; // 1 ~ n 까지 정점의 연결 요소 계산
		visited = new boolean[n+1]; // 1 ~ n 까지의 요소가 사용 되었는지
		
		for(int i = 0 ; i <= n; i++) {
			conn[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) { // 입력
			st = new StringTokenizer(br.readLine());
			
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			conn[u].add(v);
			conn[v].add(u);
		}
		
		for(int i = 1; i <=n ; i++) { // 확인
//			System.out.println(i + "번 정점 : " + conn[i]);
		}
		
		int res = 0;
		
		for(int i = 1; i <=n ; i++) { // n번 정점의 연결요소 확인
			if(visited[i] == false) { // i번째 요소가 안쓰인 경우
				visited[i] = true;
				dfs(i); // dfs로 전부 체크
				res++;
			}
		}
		
		System.out.println(res);
		
	}
	
	static void dfs(int num) {
		
		for(int i : conn[num]) {
			if(visited[i] == false) {
				visited[i] = true;
				dfs(i);
			}
		}
		return;
		
	}
}
