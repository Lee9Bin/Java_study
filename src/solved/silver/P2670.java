package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        double[] dp = new double[n];
        dp[0] = nums[0];

        double maxProduct = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
            maxProduct = Math.max(maxProduct, dp[i]);
        }

        System.out.println(String.format("%.3f", maxProduct));
    }
}
