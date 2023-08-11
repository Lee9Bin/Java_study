package programmers.level1.둘만의_암호;

import java.util.*;
public class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String[] sarr = s.split("");
        String[] skarr = skip.split("");
        Arrays.sort(skarr);
        for (int i = 0; i<sarr.length; i++){
            char nows = sarr[i].charAt(0);
            for (int k = 0; k<index; k++){
                nows +=1;
                if((int)nows == 123){
                    nows = 'a';
                }
                for (int j = 0; j < skarr.length; j++){
                    if (skarr[j].charAt(0) == nows){
                        nows +=1;
                    }
                    if((int)nows == 123){
                        nows = 'a';
                        j = -1;
                    }
                }
            }
            if((int)nows == 123){
                nows = 'a';
            }
            answer += nows + "";
            // System.out.println(nows);
        }
        return answer;
    }
}