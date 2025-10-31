import java.util.*;

// System.out.println(); //

class Solution {
    public int[] solution(String[] operations) {

        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String oper : operations){
            StringTokenizer st = new StringTokenizer(oper);
            
            String comm = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            // System.out.println("Comm : " + comm + "/ Num : " + num); //
            
            switch(comm){
                case "I":
                    map.put(num, 1);
                    break;
                case "D":
                    if(num == 1){ // Del Max
                        if(map.size() > 0){
                            map.remove(map.lastKey());
                        }                    
                    } else if (num == -1){ // Del Min
                        if(map.size() > 0){
                            map.remove(map.firstKey());
                        }
                    }
                    break;       
            }
        }
        
        if(map.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        
        // System.out.println(map); //

        return answer;
    }
}