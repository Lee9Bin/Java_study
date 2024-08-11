package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P13333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        nums.sort(Collections.reverseOrder());

        int start = nums.get(0);
        int result = 0;
        for (int i = start; i >= 0; i--) {
            int up = 0;
            for (Integer num : nums) {
                if (num >= i) up++;
            }
            if (up >= i) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
