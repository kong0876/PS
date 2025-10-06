import java.util.*;


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0,0} ; // [탈락한 사람 번호, 탈락 차례]

        int cnt = 0;
        char last = words[0].charAt(0);
        HashSet<String> used = new HashSet<>();
        
        for(String word : words){
            if(used.contains(word) || word.charAt(0) != last) {
                System.out.println("break");
                break;
            }
            
            used.add(word);
            last = word.charAt(word.length() - 1);
            cnt ++;
            
        }
        
        if(cnt == words.length){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = cnt % n + 1;
            answer[1] = cnt / n + 1;
        }

        return answer;
    }
}