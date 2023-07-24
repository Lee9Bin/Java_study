package programmers.level1.문자열_내_마음대로_정렬하기;

import java.util.*;
public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        Arrays.sort(strings, (s1,s2)->Character.compare(s1.charAt(n),s2.charAt(n)));
        for (int i=0; i<strings.length; i++){
            answer[i] = strings[i];
        }
        return answer;
    }
}