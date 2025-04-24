import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    int maxDepth;
    int[] com;
    int res = 0;
    int[] n;
    int t;
    public int solution(int[] numbers, int target) {
        maxDepth = numbers.length;
        com = new int[maxDepth];
        n = new int[maxDepth];
        t = target;
        
        for(int i = 0; i < maxDepth; i++){
            n[i] = numbers[i];
        }
        
        dfs(0);
        
        
        
        // System.out.println(sb);
        return res;
    }
    
    void dfs(int depth){
        if(depth == maxDepth){
            sb.append(Arrays.toString(com));
            int temp = 0;
            for(int i = 0; i < depth; i++){
                if(com[i] == 0){
                    temp += n[i];
                }else{
                    temp -= n[i];
                }
            }
            if(temp == t){
                res ++;
            }
            return;
        }
        
        for(int i = 0; i <= 1; i++){
            com[depth] = i;
            dfs(depth + 1);
        }
    }
}