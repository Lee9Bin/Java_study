package programmers.level1.핸드폰_번호_가리기;

public class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for (int i =0; i<phone_number.length();i++){
            if (phone_number.length()-i<=4){
                answer+=phone_number.charAt(i);
            }
            else {
                answer += "*";
            }
        }

        return answer;
    }
}
