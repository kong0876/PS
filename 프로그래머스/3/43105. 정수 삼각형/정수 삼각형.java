import java.math.*;


class Solution {
    public int solution(int[][] triangle) {
        
        int len = triangle.length;
        
        for(int depth = 1 ; depth < len; depth ++){
            // System.out.println("Depth : " + depth); //
        
            for(int idx = 0; idx <= depth; idx++){
                if(idx == 0){
                    triangle[depth][idx] += triangle[depth - 1][0];
                } else if (idx == depth){
                    triangle[depth][idx] += triangle[depth - 1][idx - 1];
                } else{
                    triangle[depth][idx] += Math.max(triangle[depth - 1][idx - 1], triangle[depth - 1][idx]);
                }
            }
        }
        
        int maxVal = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++){
            maxVal = Math.max(maxVal, triangle[len-1][i]);
        }
        
        
        return maxVal;
    }
}