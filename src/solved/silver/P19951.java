package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            height[i] = Integer.parseInt(st.nextToken());

        }

        int[] K = new int[N];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            K[start-1] += cost;
            if (end < N) K[end] -= cost;
        }

        int[] prefix = new int[N];
        prefix[0] = K[0];
        for (int i = 1; i < N; i++){
            prefix[i] = prefix[i-1] + K[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            sb.append(height[i] + prefix[i]).append(" ");
        }
        System.out.println(sb);
    }
}
