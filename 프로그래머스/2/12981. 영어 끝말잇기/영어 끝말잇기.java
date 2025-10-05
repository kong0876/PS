import java.util.*;

// System.out.println();

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0}; // 번호, 차례

        HashSet<String> set = new HashSet<>();
        
        int cnt = 0;
        char last = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            String word = words[i];
            
            if(set.contains(word) || word.charAt(0)!= last){
                cnt = i;
                break;   
            }

            set.add(word);
            last = word.charAt(word.length() - 1);
               
        }
        if(cnt != 0){
            answer[0] = (cnt % n) + 1;
            answer[1] = (cnt / n) + 1;
        }

        return answer;
    }
}