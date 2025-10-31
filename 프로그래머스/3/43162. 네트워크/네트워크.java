import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visitIdx = new boolean[n];
        int grpCnt = 0;
        
        for(int comIdx = 0; comIdx < n; comIdx ++){
            if(!visitIdx[comIdx]){
                grpCnt ++;
                // System.out.println("Group : " + grpCnt); //
                func(comIdx, n, computers, visitIdx);
            }
        }
        
        return grpCnt;
    }
    
    public void func(int comIdx, int n, int[][] computers, boolean[] visitIdx){
        
        visitIdx[comIdx] = true;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(comIdx);
        
        while(!q.isEmpty()){
            int curIdx = q.poll();
            int[] curCom = computers[curIdx];
            
            // System.out.println(cur); //
            
            for(int next = 0; next < n; next ++){
                if(next == curIdx) continue;
                if(!visitIdx[next] && curCom[next] == 1){
                    visitIdx[next] = true;
                    q.offer(next);
                }
            }
        }
        
    }
}