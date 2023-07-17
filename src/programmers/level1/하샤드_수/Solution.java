package programmers.level1.하샤드_수;

public class Solution {
    public boolean solution(int x) {
        int original = x;
        int sum = 0;
        boolean answer = true;
        String s = Integer.toString(x);
        System.out.println(s);
        for (int i = 0; i <s.length(); i++)
            sum += s.charAt(i) - '0';
        System.out.println(sum);
        //        while (x > 0) {
//            sum += x % 10;
//            x = x / 10;
//        }
//
//        if (original % sum != 0){
//            answer = false;
//        }
        return answer;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.solution(10);
    }
}