package programmers.level1.로또의_최고_순위와_최저_순위;

import java.util.*;
public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6,6};
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int cnt = 0;
        int zero = 0;
        for (int i=0; i<6; i++){
            if (lottos[i] == 0){
                zero+=1;
            }
            for (int j = 0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    cnt +=1;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(zero);

        if (cnt + zero >= 6){
            answer[0] = 1;
        }
        else if (cnt + zero >= 5){
            answer[0] = 2;
        }
        else if (cnt + zero >= 4){
            answer[0] = 3;
        }
        else if (cnt + zero >= 3){
            answer[0] = 4;
        }
        else if (cnt + zero >= 2){
            answer[0] = 5;
        }

        if (cnt >= 6){
            answer[1] = 1;
        }
        else if (cnt >= 5){
            answer[1] = 2;
        }
        else if (cnt >= 4){
            answer[1] = 3;
        }
        else if (cnt >= 3){
            answer[1] = 4;
        }
        else if (cnt >= 2){
            answer[1] = 5;
        }

        return answer;
    }
}