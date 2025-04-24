import java.util.*;

class Loc{
    int row;
    int col;
    int depth;
    
    Loc(int row, int col, int depth){
        this.row = row;
        this.col = col;
        this.depth = depth;
    }
}

class Solution {
    
    ArrayDeque<Loc> q = new ArrayDeque<>();
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};
    boolean[][] visit;
    
    public int solution(int[][] maps) {
        int res = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        visit = new boolean[n][m];
        visit[0][0] = true;
        q.offer(new Loc(0,0,1));
        
        while(!q.isEmpty()){
            Loc cur = q.poll();
            if(cur.row == n - 1 && cur.col == m - 1){
                res = cur.depth;
                return res;
            }
            for(int i = 0; i < 4; i++){
                int nx = cur.row + dx[i];
                int ny = cur.col + dy[i];
                
                if(nx >= 0 && nx < n && ny >=0 && ny < m && visit[nx][ny]==false){
                    
                    if(maps[nx][ny] == 1){
                        visit[nx][ny] = true;
                        q.offer(new Loc(nx, ny, cur.depth + 1));
                    }
                }
            }
        }
        
        return res;
    }
}