package programmers.level1.가운데_글자_가져오기;

public class Solution {
    public String solution(String s) {
        String answer;
        if (s.length() % 2 == 0){
            answer = s.substring(s.length()/2-1,s.length()/2+1);
        }
        else {
            answer = s.substring(s.length()/2,s.length()/2+1);
        }
        return answer;
    }
}