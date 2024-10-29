package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            sum[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = 0; i <= sum[0]; i++) {
            int start = i;
            int now = start;
            boolean flag = true;
            for (int j = 1; j < N; j++) {
                now = sum[j - 1] - now;
                if (now < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && start + now == sum[N - 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(start).append("\n");
                for (int j = 1; j < N; j++) {
                    sb.append(sum[j - 1] - start).append("\n");
                    start = sum[j - 1] - start;
                }
                System.out.println(sb);
                break;
            }
        }
    }
}
