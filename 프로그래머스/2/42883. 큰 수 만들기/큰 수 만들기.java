class Solution {
    
    // StringBuilder tmp = new StringBuilder();

    
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder answerBuilder = new StringBuilder();
        
        char[] arr = number.toCharArray();
        int len = arr.length;

        // tmp.append("배열 : ").append(arr).append(" / 길이 : " + len);
        
        int target = len - k;
        // tmp.append(" / target : " + target);
        
            
        int idx = 0;

        // 각 자리의 최댓값 계산
        for(int i = 0; i < target; i++) { 
            char max = '0';
            for(int j = idx; j < len - (target - i - 1); j++){
                if(arr[j] > max){
                    max = arr[j];
                    idx = j + 1;
                }
            }
            
            answerBuilder.append(max);
        }
        
        // System.out.println(tmp.toString());
        
        answer = answerBuilder.toString();
        return answer;
    }
}