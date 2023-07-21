package programmers.level1.문자열_내림차순으로_배치하기;

import java.util.*;

public class Solution {
    public String solution(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i<s.length(); i++){
            result[i] = s.charAt(i);
        }
        Arrays.sort(result);
        String answer = "";

        for (int i = result.length-1; i>=0; i--){
            answer += result[i];
        }
        return answer;
    }
}