class Solution {
    StringBuilder sb = new StringBuilder();
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //
        int sum = brown + yellow;
        
        for(int i = 1; i <= sum / 2 ; i++){
            for(int j = i; j <= sum/2; j++){
                if(i*j == sum){
                    if((j-2) * (i-2) == yellow){
                        answer[0] = j;
                        answer[1] = i;
                        
                        return answer;
                    }
                }
            }
        }
        return answer;
        //
    }
}