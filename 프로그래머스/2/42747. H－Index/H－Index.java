import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    
    public int solution(int[] citations) {
        int answer = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int c : citations) arr.add(c);
       
        Collections.sort(arr, Collections.reverseOrder());
        
        sb.append(arr);
        System.out.println(sb);
        
        for(int h = arr.get(0); h >= 0; h--){
            int temp = 0;
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i) >= h){
                    temp ++;
                }
                if(temp > h) break;
            }
            if(temp >= h){
                if(temp >= arr.size() - temp){
                    answer = h;
                    break;
                }
            }
        }

        
        return answer;
    }
}