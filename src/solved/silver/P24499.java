package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int total = 0;
        int result = 0;
        for (int i = 0; i < N + K; i++) {
            if (i < K) total += nums[i % N];
            else {
                result = Math.max(result, total);
                total -= nums[i - K];
                total += nums[i % N];
            }
        }

        System.out.println(result);
    }
}
