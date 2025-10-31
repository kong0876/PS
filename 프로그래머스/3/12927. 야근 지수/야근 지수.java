import java.util.*;
import java.math.*;

// System.out.println(); //

class Solution {
    public long solution(int n, int[] works) { // n시간
        long answer = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int work : works) {
            map.put(work, map.getOrDefault(work, 0) + 1);
        }
        
        // System.out.println(map); //
        
        while(n > 0 && !map.isEmpty()){
            int lK = map.lastKey();
            
            if(map.get(lK) == 0){
                map.remove(lK);
            } else{
                map.put(lK, map.get(lK) - 1);
                map.put(lK-1, map.getOrDefault(lK-1, 0) + 1);
                n--;
            }
        }
            
        // System.out.println(map); // 

        for(int k : map.keySet()){
            if(k > 0){
                // System.out.println(Math.pow(k, 2) * map.get(k)); //
                answer += Math.pow(k, 2) * map.get(k);
            }
        }
        
        
        return answer;
    }
}