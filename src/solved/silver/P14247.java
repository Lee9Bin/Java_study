package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] trees = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trees[i][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trees[i][1] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += trees[i][0] + i * trees[i][1];
        }

        System.out.println(result);
    }
}
