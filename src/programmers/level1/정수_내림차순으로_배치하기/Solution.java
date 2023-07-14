package programmers.level1.정수_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        String[] arr = new String[str.length()];

        for (int i = 0; i< str.length(); i++){
            arr[i] = str.charAt(str.length()-1-i)+"";
        }
        Arrays.sort(arr, Collections.reverseOrder());
        long answer = Long.parseLong(String.join("",arr));
        return answer;
    }
}