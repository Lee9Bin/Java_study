package programmers.level1.최대공약수와_최소공배수;

public class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        for(int i =1; i<(n>m?m:n); i++){
            if (n%i == 0 && m%i==0){
                answer[0] = i;
            }
        }
        for(int i =(n>m?n:m); i<=n*m; i++){
            if (i%n == 0 && i%m==0){
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}