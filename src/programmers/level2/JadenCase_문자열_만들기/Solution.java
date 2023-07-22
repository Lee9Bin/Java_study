package programmers.level2.JadenCase_문자열_만들기;

public class Solution {
    public String solution(String s) {
        int cnt = 0;
        String answer = "";

        for (int i = 0; i<s.length() ; i++){
            if (' ' == s.charAt(i)){
                answer += ' ';
                cnt = 0;
                continue;
            }
            if (cnt == 0){
                answer += Character.toString(s.charAt(i)).toUpperCase();
            }
            else{
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
            cnt +=1;
        }
        return answer;
    }
}