//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.offer(s);
        
        while(pq.peek() < K){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            pq.offer(pq.poll() + pq.poll() * 2);
            answer ++;
        }
        
        // sb.append(pq);
        // System.out.println(sb);
        
        return answer;
    }
}