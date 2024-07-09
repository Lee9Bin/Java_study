package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] peoples = new int[1000002];

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            peoples[start] += 1;
            peoples[end+1] -= 1;
        }

        int[] dp = new int[1000002];
        for (int i = 1; i < 1000001; i++){
            dp[i] = dp[i-1] + peoples[i];
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);


    }
}
