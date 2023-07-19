package programmers.level1.제일_작은_수_제거하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        System.out.println(answer.length);
        int minNum = 1234567891;
        for (int i = 0; i<arr.length; i++){
            if(minNum > arr[i]){
                minNum = arr[i];
            }
        }
        int cnt = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i] == minNum){
                continue;
            }
            answer[cnt] = arr[i];
            cnt ++;
        }
        if (arr.length == 1){
            answer = new int[]{-1};
        }
        return answer;
    }
}