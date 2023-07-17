package programmers.level1.두_정수_사이의_합;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        for (int i= a>b ? b:a; i< (a>b ? a+1:b+1); i++){
            answer += i;
        }
        return answer;
    }
}