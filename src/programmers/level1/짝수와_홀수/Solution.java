package programmers.level1.짝수와_홀수;

public class Solution {
    public String solution(int num) {
        String answer = "";
        if (num % 2 == 0){
            answer = "Even";
        }
        else if (num % 2 != 0){
            answer = "Odd";
        }
        return answer;
    }
}