import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static class Loc{
		int row;
		int col;
		
		Loc(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // row
		int m = Integer.parseInt(st.nextToken()); // col
		
		
		char[][] arr = new char[n][m];
		boolean[][] visit = new boolean[n][m];
		
		int girl_row = 0;
		int girl_col = 0;
		
		for(int row = 0; row < n; row++) {
			String input = br.readLine();
			for(int col = 0; col < m; col++) {
				arr[row][col] = input.charAt(col);
				if(arr[row][col] == 'I') {
					girl_row = row;
					girl_col = col;
				}
			}
			
		}
		
		
		ArrayDeque<Loc> q = new ArrayDeque<>();
		
		q.add(new Loc(girl_row, girl_col));
		
		int res = 0;;
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.row + dx[i];
				int ny = cur.col + dy[i];
				
				if(nx >=0 && nx < n && ny >= 0 && ny < m && visit[nx][ny] == false) {
					if(arr[nx][ny] == 'O') {
						q.add(new Loc(nx, ny));
						visit[nx][ny] = true;
					}
					else if(arr[nx][ny] == 'P') {
						res++; 
						q.add(new Loc(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
		}		
		System.out.println(res != 0? res : "TT");
		
	}
}