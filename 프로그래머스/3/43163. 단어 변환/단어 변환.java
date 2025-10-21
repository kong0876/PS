import java.util.*;
import java.math.*;
class Solution {
    
    static int res = Integer.MAX_VALUE;
    static String tWord;
    static int wCnt = 0;
    static int wLen = 0;
    static boolean[] visit;
    static String[] sWords;
    
    public int solution(String begin, String target, String[] words) {
        
        tWord = target;
        wCnt = words.length;
        wLen = begin.length();
        visit = new boolean[wCnt];
        sWords = words;
        
        dfs(0, begin);
        
        return res==Integer.MAX_VALUE?0:res;
    }
    
    public void dfs(int depth, String str){
        // System.out.println(depth + " , " + str);
        
        if(str.equals(tWord)){
            res = Math.min(res, depth);
            return;
        }
        
        for(int i = 0; i < wCnt; i++){
            if(visit[i] == false){
                int diff = 0;
                
                for(int j = 0; j < wLen; j++){
                    if(str.charAt(j) != sWords[i].charAt(j)) diff++;
                }
                
                if(diff == 1) {
                    visit[i] = true;
                    dfs(depth+1, sWords[i]);
                    visit[i] = false;
                }
            }
        }
        
        
    }
}