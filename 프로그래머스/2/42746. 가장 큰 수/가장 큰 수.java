import java.util.*;

class Solution {
    ArrayList<String> arr = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    public String solution(int[] numbers) {
        
        for(int n : numbers){
            arr.add(Integer.toString(n));
        }
        
        Collections.sort(arr, (a,b) -> (b + a).compareTo(a + b));
        
        if(arr.get(0).equals("0")) return "0";
        
        for(String n : arr){
            sb.append(n);
        }
        
        
        return sb.toString();
    }
}