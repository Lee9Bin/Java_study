package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12738 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];
        int[] dpIndex = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = len-1;
            int index = len;
            while(left <= right) {
                int mid = (left+right)/2;

                if (dp[mid] >= nums[i]) {
                    right = mid-1;
                    index = mid;
                }
                else {
                    left = mid+1;
                }
            }

            if(len == index ) {
                len ++;
            }
            dpIndex[i] = index;
            dp[index] = nums[i];

        }

        StringBuilder sb = new StringBuilder();
        int[] result = new int[len];
        for (int i = n-1; i >= 0; i--) {
            if (dpIndex[i] == len-1) {
                result[len-1] = nums[i];
                len--;
            }
        }
        System.out.println(result.length);
    }
}
