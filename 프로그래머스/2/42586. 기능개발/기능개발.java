import java.util.*;

class Work{
    int p;
    int s;
    
    Work(int progress, int speed){
        this.p = progress;
        this.s = speed;
    }
}

class Solution {
    StringBuilder sb = new StringBuilder();
    ArrayDeque<Work> q = new ArrayDeque<>();
    int pNum;
    ArrayList<Integer> res = new ArrayList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        pNum = speeds.length;
        
        for(int i = 0; i < pNum; i++){
            q.offer(new Work(progresses[i], speeds[i]));
        }
        
        while(!q.isEmpty()){
            oneDay();
        }
                
        int [] answer = new int[res.size()];
        
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    
    void oneDay(){
        
        for(Work w : q){
            w.p += w.s;
        }
        
        int temp = 0;

        for(Work w : q){
            if(w.p >= 100){
                q.poll();
                temp ++;
            }else{
                break;
            }
        }
        if(temp != 0) res.add(temp);

    }

}