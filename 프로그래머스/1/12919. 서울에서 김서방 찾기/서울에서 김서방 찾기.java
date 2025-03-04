class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        int loc = 0;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")) loc = i;
        }
        
        sb.append("김서방은 ").append(loc).append("에 있다");

        return sb.toString();
    }
}