package programmers.level1.서울에서_김서방_찾기;

public class Solution {
    public String solution(String[] seoul) {
        int result = 0;
        for (int i = 0; i<seoul.length; i++){
            String s = seoul[i];
            if (s.equals("Kim")){
                System.out.println("!@3123");
                result = i;
                System.out.println(result);
                break;
            }
        }
        System.out.println(result);
        String answer = "김서방은 "+result+"에 있다";
        System.out.println(answer);
        return answer;
    }

}