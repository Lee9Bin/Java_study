package programmers.level1.추억_점수;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> dic = new HashMap<>();
        for (int i = 0; i<name.length; i++){
            try{
                dic.put(name[i],yearning[i]);
            }
            catch (Exception e){
                continue;
            }
        }
        int[] answer = new int[photo.length];
        int cnt = 0;
        for (String[] arr:photo){
            int sum = 0;
            for (String str:arr){
                try{
                    sum += dic.get(str);
                }
                catch (Exception e){
                    continue;
                }
            }
            answer[cnt] = sum;
            cnt +=1;
        }
        return answer;
    }
}