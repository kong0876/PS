import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Boolean> map = new HashMap<>();
        
        for(String phone_num : phone_book){
            map.put(phone_num, true);
        }
        
        for(String phone_num : phone_book){
            for(int i = 1; i < phone_num.length(); i++){
                if(map.containsKey(phone_num.substring(0,i))) answer = false;
            }
        }        
        
        return answer;
    }
}