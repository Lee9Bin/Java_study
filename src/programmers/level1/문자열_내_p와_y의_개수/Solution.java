package programmers.level1.문자열_내_p와_y의_개수;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0;
        int ycnt = 0;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p'){
                pcnt +=1;
            }
            else if(s.charAt(i) == 'Y' || s.charAt(i) == 'y'){
                ycnt +=1;
            }
        }
        if (pcnt != ycnt){
            answer =false;
        }
        return answer;
    }
}