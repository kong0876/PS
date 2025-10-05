import java.util.*;

// System.out.println();

class Solution {
    public int solution(int k, int[] tang) {
        int answer = 0;
        
        HashMap<Integer, Integer> freq = new HashMap<>(); // (무게, 빈도)
        
        // 빈도 입력
        for(int t : tang){
            if(!freq.containsKey(t)){
                freq.put(t, 1);
            }
            else{
                freq.put(t, freq.get(t) + 1);
            }
        }
        
        // System.out.println(freq);

        // 배열에 넣음
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int v : freq.values()){
            arr.add(v);
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        
        // System.out.println(arr);
        
        // 큰 순서대로 넣어봄
        int temp = 0;
        
        for(int i : arr){
            if(temp >= k) break;
            temp += i;
            answer++;
        }
        
        
        return answer;
    }
}