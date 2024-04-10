package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class P10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length(); i++){
            int num = nums.charAt(i) - '0';
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            if (!map.containsKey(num)) map.put(num, 1);
        }

        if(map.containsKey(0)){
            int total = 0;
            for (Integer integer : map.keySet()) {
                total += integer*map.get(integer);
            }
            if (total % 3 == 0){
                char[] ch = nums.toCharArray();
                Arrays.sort(ch);
                for(int i = ch.length-1; i >= 0; i--){
                    System.out.print(ch[i]);
                }
            }
            else{
                System.out.println(-1);
            }
        }
        else{
            System.out.println(-1);
        }
    }
}
