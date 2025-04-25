class Solution {
    StringBuilder sb = new StringBuilder();
    int dNum;
    boolean[] visit;
    int[] res;
    int gK;
    int[][] gDungeons;
    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        gK = k;
        gDungeons = new int[dungeons.length][dungeons[0].length];
        
        for(int row = 0; row < dungeons.length; row++){
            for(int col = 0; col < dungeons[0].length; col++){
                gDungeons[row][col] = dungeons[row][col];
            }
        }
        ///
        dNum = dungeons.length;
        visit = new boolean[dNum];
        res = new int[dNum];
        
        dfs(0);
        
        ///
        sb.append(answer);
        System.out.println(answer);
        return answer;
    }
    void dfs(int depth){
        if(depth == dNum){
            sb = new StringBuilder();
            for(int i = 0; i < dNum; i++){
                sb.append(res[i]);
            }
            go(sb.toString());
            return;
        }
        for(int i = 0; i < dNum; i++){
            if(visit[i] == false){
                visit[i] = true;
                res[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
    
    void go(String com){
        int rK = gK;
        int tempRes = 0;
        
        for(int i = 0; i < com.length(); i++){
            if(gDungeons[com.charAt(i) - '0'][0] <= rK){
                rK -= gDungeons[com.charAt(i) - '0'][1];
                tempRes++;
            } else{
                break;
            }
        }
        
        answer = Math.max(answer, tempRes);
    }
}