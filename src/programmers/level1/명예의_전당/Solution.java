package programmers.level1.명예의_전당;

import java.util.*;

public class Solution {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int day = 0; day < score.length; day++) {
            if (arr.size() == k) {
                if (arr.get(0) <= score[day]) {
                    arr.remove(0);
                    arr.add(score[day]);
                    Collections.sort(arr);
                    answer[day] = arr.get(0);
                } else {
                    answer[day] = answer[day - 1];
                }
            } else if (arr.size() < k) {
                arr.add(score[day]);
                Collections.sort(arr);
                answer[day] = arr.get(0);
            }
        }
        return answer;
    }
}