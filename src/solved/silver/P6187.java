package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6187 {

    static int[] cows;
    static int C, N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        result = 0;
        cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int index, int total) {
        if (index == N) {
            if (C >= total) {
                result = Math.max(result, total);
            }
            return;
        }

        dfs(index + 1, total + cows[index]);
        dfs(index + 1, total);
    }
}
