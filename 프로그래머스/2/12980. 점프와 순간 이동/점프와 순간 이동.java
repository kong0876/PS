// +k(k 만큼 cost) or x2

import java.util.*;

public class Solution {
    public int solution(int n) {
        return move(n);
    }
    
    public int move(int n){
        int cnt = 0;
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                cnt++;
                n -= 1;
            }
        }
        return cnt;
    }
}