import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M]; // m개의 배열
		visited = new boolean[N+1]; // 방문 체크 배열
		
		backtrack(0);
	}
	
	static void backtrack(int depth) {
		if(depth == M) { // M개 다 뽑은 경우
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자 선택 (!!!!!!!!!여기가 중요)
			if(!visited[i]) { // i가 안뽑힌 경우에
				visited[i] = true; // 내가 뽑겠다.
				arr[depth] = i; // depth 번째 숫자는 i다.
				backtrack(depth + 1); // 하나를 뽑은 상태에서 이제 다시 뽑음
				visited[i] =false; // 다 뽑고 난 뒤에 복귀
			}
		}
	}
}