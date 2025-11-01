import java.util.*;

// System.out.println(); //

class Solution {
    public int solution(int[] A, int[] B) {
        int bScore = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        // System.out.println(Arrays.toString(A)); // 
        // System.out.println(Arrays.toString(B)); // 
        
        int aIdx = 0;
        int bIdx = 0;
        
        while(aIdx < A.length && bIdx < B.length){
            if(A[aIdx] < B[bIdx]) {
                bScore ++;
                aIdx ++;
                bIdx ++;
            } else{
                bIdx ++;
            }
        }
        
        
        return bScore;
    }
}