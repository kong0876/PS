import java.io.*;
import java.util.*;

// [14940 쉬운 최단 거리]
// 시간 :  / 메모리 : 

// 모든 지점에서 목표 지점까지의 거리 구하라 (가로 / 세로 이동만 가능), 0:갈수 없는 땅, 1:갈 수 있는 땅, 2:목표 지점 (하나)

// -> BFS로 1씩 늘림
public class Main {

	static class Cur {
		int row;
		int col;
		int val;
		
		Cur(int row, int col) {
			this.row = row;
			this.col = col;
		}
		Cur(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	static int n, m;
	static int[][] map;
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static boolean[][] visit;
	static int[][] res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로, Row
		m = Integer.parseInt(st.nextToken()); // 가로, Col
		map = new int[n][m];
		visit = new boolean[n][m];
		res = new int[n][m];
		
		ArrayDeque<Cur> q = new ArrayDeque<>();

		// 입력
		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < m; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if (map[row][col] == 2) { // 목표지점에서 부터 BFS
					q.offer(new Cur(row, col, 0));
					visit[row][col] = true;
					res[row][col] = 0;
				}
			}
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if(map[row][col] == 1){
					res[row][col] = -1;

				}
			}
		}		
		// BFS를 돌며 체크
		while (!q.isEmpty()) {
			Cur cur = q.poll();
			int row = cur.row;
			int col = cur.col;
			int cVal = cur.val + 1;
			
			for (int i = 0; i < 4; i++) {
				int nx = row + dx[i];
				int ny = col + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					res[nx][ny] = cVal;
					q.offer(new Cur(nx, ny, cVal));
				}
			}
		}
		
		// 출력
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				System.out.print(res[row][col] + " ");
			}
			System.out.println();
		}
		
	}
}
