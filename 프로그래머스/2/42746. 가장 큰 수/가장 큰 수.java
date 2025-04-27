import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        ArrayList<String> arr = new ArrayList<>();
        
        for(Integer n : numbers){
            arr.add(Integer.toString(n));
        }
        
        Collections.sort(arr, ((o1,o2) -> (o2 + o1).compareTo(o1 + o2)));
        
        for(String s : arr){
            answer.append(s);
        }
        
        if(arr.get(1).equals("0")) return "0";
        
        return answer.toString();
    }
}