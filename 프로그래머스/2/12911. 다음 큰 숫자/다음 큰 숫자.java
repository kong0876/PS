class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cur = n + 1;
        
        while(true){
            if(func(cur) == func(n)) break;
            cur ++;
        }
        
        answer = cur;
        
        return answer;
    }
    
    public int func(int n) {
        int cnt = 0;
        
        while(n > 0){
            
            cnt += n % 2;
            n /= 2;
            
            // System.out.println(" n : " + n + ", cnt : " +  cnt);
        }
        
        return cnt;
    }
}