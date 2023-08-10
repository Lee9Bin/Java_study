package programmers.level1.문자열_나누기;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int dif = 0;
        char first = s.charAt(0);
        for(int i = 0; i<s.length(); i++){
            if (i == s.length()-1){
                answer++;
                continue;

            }
            if(first==s.charAt(i)){
                same ++;
            }
            else{
                dif ++;
            }
            if(same == dif){
                first = s.charAt(i+1);
                answer++;
                same = 0;
                dif = 0;
            }
        }
        return answer;
    }
}