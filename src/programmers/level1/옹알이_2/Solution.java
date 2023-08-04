package programmers.level1.옹알이_2;

public class Solution {
    public int solution(String[] babbling) {
        String[] possible = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (int i = 0; i<babbling.length; i++){
            for (int j = 0; j<4; j++){
                babbling[i] = babbling[i].replace(possible[j]+possible[j],"x");
                babbling[i] = babbling[i].replace(possible[j],"*");
            }
            for (int j = 0; j<babbling[i].length()+1; j++){
                if(j == babbling[i].length()){
                    answer +=1;
                    break;
                }
                if(babbling[i].charAt(j) != '*'){
                    break;
                }
            }
        }
        return answer;
    }
}