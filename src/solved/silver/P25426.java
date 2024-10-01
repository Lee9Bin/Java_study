package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P25426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] fx = new long[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            fx[i] = new long[]{a, b};
        }

        Arrays.sort(fx, (long[] o1, long[] o2) -> {
            return o1[0] != o2[0] ? Long.compare(o1[0], o2[0]) : Long.compare(o1[1], o2[1]);
        });

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += fx[i][0] * (i + 1) + fx[i][1];
        }
        System.out.println(result);
    }
}
