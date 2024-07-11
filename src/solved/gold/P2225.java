package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2225 {
    static int N, K;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //1~N개 중에 K개를 뽑아서 합이 N이 되도록

        int[][] dp = new int[K+1][N+1];

        for (int[] ints : dp) {
            Arrays.fill(ints , 1);
        }

        for (int i = 2; i < K+1; i++){
            for (int j = 1; j < N+1; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }

}