import java.util.*;

class Solution {
    
    char[] moum = new char[]{'X', 'A', 'E', 'I', 'O', 'U'};
    char[] res = new char[5];
    
    TreeSet<String> set = new TreeSet<>();
    TreeMap<String, Integer> map = new TreeMap<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs(0);
        
        for(String s : set){
            if(word.equals(s)) break;
            answer++;
        }
                
        return answer;
    }
    
    void dfs(int depth){
        if(depth == 5){
            StringBuilder sb = new StringBuilder();
            
            for(char c : res){
                if(c == 'X'){
                    sb.append("");
                }else{
                    sb.append(c);
                }
            }
            set.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < 6; i++){
            res[depth] = moum[i];
            dfs(depth + 1);
        }
    }
}