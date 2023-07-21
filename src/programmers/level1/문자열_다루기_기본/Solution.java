package programmers.level1.문자열_다루기_기본;

public class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6 ){
            answer = false;
        }
        int ch = s.charAt(0);
        if (65<=ch){
            for (int i = 0; i<s.length(); i++){
                if((int)s.charAt(i)<65){
                    answer = false;
                }
            }
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                if ((int)s.charAt(i)>= 65) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}