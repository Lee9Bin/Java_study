package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5604 {

    static long[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        dp = new long[16];
        dp[1] = 1;
        for (int i = 2; i < 16; i++) {
            dp[i] = dp[i-1] * 10 + (long)Math.pow(10, i-1);
        }

        StringBuilder sb = new StringBuilder();
        for (int testNum = 1; testNum <= testCase; testNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            sb.append("#").append(testNum).append(" ").append(findSum(b, length(b)) - findSum(a-1, length(a-1))).append("\n");
        }

        System.out.println(sb);

    }

    public static int length(long n) {
        int len = 0;
        while (n > 0) {
            n /= 10;
            len++;
        }
        return len;
    }

    public static long findSum(long n, int cnt) {
        long result = 0;
        long[] nums = new long[10];

        while (n > 0){
            long frontNum = n / (long)Math.pow(10,cnt-1);
            for(int i = 0; i < frontNum; i++){
                for(int j = 0; j < 10; j++){
                    nums[j] += dp[cnt-1];
                }
                nums[i] += (long)Math.pow(10,cnt-1);
            }
            long backNum = n % (long)Math.pow(10,cnt-1);
            nums[(int)frontNum] += (backNum+1);
            n = n % (long)Math.pow(10,cnt-1);
            cnt--;
        }

        for (int i = 1; i < 10; i++){
            result += i * nums[i];
        }

        return result;
    }
}
