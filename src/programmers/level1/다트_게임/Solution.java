package programmers.level1.다트_게임;

import java.util.*;
public class Solution {
    public int solution(String dartResult) {
        ArrayList <Integer> point = new ArrayList<>();
        String nown = "";
        for (int i = 0; i<dartResult.length();i++){
            if(48<=(int)dartResult.charAt(i) && (int)dartResult.charAt(i)<=57){
                nown += Character.toString(dartResult.charAt(i));
            }
            else if(65<=(int)dartResult.charAt(i) && (int)dartResult.charAt(i)<=90){
                int po = Integer.parseInt(nown);
                if (dartResult.charAt(i) == 'D'){
                    po = (int)Math.pow(po,2);
                }
                if (dartResult.charAt(i) == 'T'){
                    po = (int)Math.pow(po,3);
                }
                point.add(po);
                nown = "";
            }
            else if(dartResult.charAt(i)=='#' || dartResult.charAt(i)=='*'){
                if (dartResult.charAt(i)=='*'){
                    if (point.size() == 1){
                        point.set(point.size()-1,point.get(point.size()-1)*2);
                    }
                    else{
                        point.set(point.size()-1,point.get(point.size()-1)*2);
                        point.set(point.size()-2,point.get(point.size()-2)*2);

                    }
                }
                else if(dartResult.charAt(i)=='#'){
                    point.set(point.size()-1,-point.get(point.size()-1));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i<point.size(); i++){
            answer += point.get(i);
        }
        return answer;
    }
}