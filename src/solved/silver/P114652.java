package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P114652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            if (count.containsKey(num)) count.put(num, count.get(num) + 1);
            else count.put(num, 1);
        }


        int maxCount = 0;
        Long result = 0L;
        for (Long aLong : count.keySet()) {
            if (count.get(aLong) > maxCount) {
                maxCount = count.get(aLong);
                result = aLong;
            } else if (count.get(aLong) == maxCount) {
                result = Math.min(result, aLong);
            }
        }
        System.out.println(result);
    }
}
