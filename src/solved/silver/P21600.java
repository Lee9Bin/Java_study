package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int now = 0;
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (now < nums[i]) {
                now++;
                result = Math.max(result, now);
            } else {
                now = nums[i];
            }
        }
        System.out.println(result);
    }
}
