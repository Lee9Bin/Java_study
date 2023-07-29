package programmers.level1.모의고사;
import java.util.*;
public class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};;
        int ocnt =0, tcnt = 0, thcnt = 0;
        for (int i =0; i<answers.length; i++){
            if (one[i%5] == answers[i]){
                ocnt +=1;
            }
            if (two[i%8] == answers[i]){
                tcnt +=1;
            }
            if (three[i%10] == answers[i]){
                thcnt +=1;
            }
        }
        int[] student = new int[3];
        student[0] = ocnt;
        student[1] = tcnt;
        student[2] = thcnt;

        int max = student[0];
        for (int i =0; i<3; i++){
            if(max < student[i]){
                max = student[i];
            }
        }
        int cnt = 0;

        for (int i = 0; i<3; i++){
            if(max == student[i]){
                cnt +=1;
            }
        }

        int[] answer = new int[cnt];
        cnt = 0;
        for (int i = 0; i<3; i++){
            if(max == student[i]){
                answer[cnt] = i+1;
                cnt +=1;
            }
        }


        return answer;
    }
}