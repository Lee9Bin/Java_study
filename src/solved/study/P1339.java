package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P1339 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 65; i < 91; i++) {
//			System.out.println((char)i);
            map.put((char)i,0);
        }
        for (int i = 0; i < n; i++) {
            char[] word = br.readLine().toCharArray();
            for (int j = 0; j < word.length; j++) {
                map.put(word[j], map.get(word[j]) + (int)Math.pow(10, word.length-j-1));
            }
        }

        ArrayList<int[]> infos = new ArrayList<>();
        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                infos.add(new int[] {map.get(ch), ch});
            }
        }

        Collections.sort(infos,(int[] o1, int[] o2) -> {
            return o2[0] - o1[0];
        });

        long result = 0;
        int value = 9;
        for (int[] info  : infos) {
            result += info[0] * value;
            value--;
        }
        System.out.println(result);
    }
}
