package programmers.level1.콜라츠_추측;

public class Solution {
    public int solution(long num) {
        int cnt = 0;
        while (num > 1){
            System.out.println(cnt);
            if (cnt == 500){
                cnt = -1;
                break;
            }
            if (num % 2 == 0){
                num = num / 2;
            }
            else if (num % 2 != 0) {
                num = num*3 +(long)1;
            }
            System.out.println(num);
            cnt +=1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.solution(626331));
    }
}