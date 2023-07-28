package programmers.level1.카드_뭉치;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1 = 0, c2 = 0;
        String answer = "Yes";
        for (int i = 0; i<goal.length; i++){
            if(c1<cards1.length){
                if(cards1[c1].equals(goal[i])){
                    c1 +=1;
                }}
            if (c2<cards2.length){
                if(cards2[c2].equals(goal[i])){
                    c2 +=1;
                }}
        }
        if (c1+c2<goal.length){
            answer = "No";
        }
        return answer;
    }
}