package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11055 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n+1];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 1 ; i < n+1 ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        int reuslt = 1;
        for (int i = 1; i < n+1; i++) {
            dp[i] = nums[i];
            for (int j = 1; j <i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + nums[i],dp[i]);
                }
            }
        }
        for (int i : dp) {
            reuslt = Math.max(reuslt, i);
        }
        System.out.println(reuslt);
    }
}

