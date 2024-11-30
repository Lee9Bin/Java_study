package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P9770 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> nums = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int temp = GCD(nums.get(i), nums.get(j));
                result = Math.max(temp, result);
            }
        }
        System.out.println(result);
    }

    public static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        }

        return GCD(y, x % y);
    }
}
