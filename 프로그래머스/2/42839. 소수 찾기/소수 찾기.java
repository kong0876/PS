import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    int numLen;
    int[] numList;
    int[] res;
    boolean[] visit;
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        //
        numLen = numbers.length();
        numList = new int[numLen];
        res = new int[numLen];
        visit = new boolean[numLen];
        
        for(int i = 0; i < numLen; i++){
            numList[i] = numbers.charAt(i) - '0';
        }
                
        for(int i = 1; i <= numLen; i++){
            dfs(0, i);
        }
        
        for(int i : set){
            if(isPrime(i)){
                answer++;
            }
        }
        
        //
        return answer;
    }
    
    void dfs(int depth, int tDepth){
        sb.append("Target Depth : " + tDepth + "\n");
        if(depth == tDepth){
            sb = new StringBuilder();
            for(int i = 0; i < tDepth; i++){
                sb.append(res[i]);
            }
            set.add(Integer.valueOf(sb.toString()));
            return;
        }

        for(int i = 0; i < numLen; i++){
            if(visit[i] == false){
                visit[i] = true;
                res[depth] = numList[i];
                dfs(depth+1, tDepth);
                visit[i] = false;
            }
        }
    }
    
    // 소수 판단
    boolean isPrime(int num){
        if(num <= 1) return false;
        
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}