package programmers.level1.나누어_떨어지는_숫자_배열;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList solution(int[] arr, int divisor) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            if(arr[i] % divisor ==0){
                result.add(arr[i]);
            }
        }
        Collections.sort(result);
        if(result.size() == 0){
            result.add(-1);
        }
        return result;
    }
}
