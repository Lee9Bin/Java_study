package programmers.level1.대충_만든_자판;

import java.util.*;
public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (String nows : keymap){
            String[] arr = nows.split("");
            for (int i = 0; i< arr.length; i++){
                if (!map.containsKey(arr[i])){
                    map.put(arr[i],i+1);
                }
                else{
                    if (i+1 < map.get(arr[i])){
                        map.put(arr[i],i+1);
                    }
                }
            }
        }
        System.out.println(map);
        int k = 0;
        for (String s : targets){
            int sum = 0;
            boolean flag = true;
            String[] nows = s.split("");
            for (int i = 0; i<nows.length; i++){
                if (!map.containsKey(nows[i])){
                    flag = false;
                    break;
                }
                else{
                    sum += map.get(nows[i]);
                }
            }
            if (flag == true){
                answer[k] = sum;
            }
            else
            {
                answer[k] = -1;
            }
            k ++;
        }
        return answer;
    }
}