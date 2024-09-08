package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P9417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> nums = new ArrayList<>();

            while (st.hasMoreTokens()) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            int result = 0;
            for (int x = 0; x < nums.size(); x++) {
                for (int y = x + 1; y < nums.size(); y++) {
                    result = Math.max(result, GCD(nums.get(x), nums.get(y)));
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return GCD(b, a % b);
        }
    }
}
