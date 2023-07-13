package programmers.level1.정수_제곱근_판별;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        double s = Math.sqrt(n);
        if(s - (int)s == 0){
            answer = (long)((int)s +1) *(long)((int)s +1);
        }
        else{
            answer = -1;
        }
        return answer;
    }
}