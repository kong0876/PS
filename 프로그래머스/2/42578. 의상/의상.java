import java.util.*;

class Solution {
    
    StringBuilder sb = new StringBuilder();
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int res = 1;
        for(String[] c : clothes){
            if(map.containsKey(c[1])){
                map.put(c[1], map.get(c[1]) + 1);
            }else{
                map.put(c[1], 1);
            }
        }
        
        for(String key : map.keySet()){
            res *= map.get(key) + 1;
        }
        
        
        return res -1;
    }
}