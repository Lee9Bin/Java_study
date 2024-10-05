package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dif = N / 2;
        int left = N / 2;
        int right = N % 2 == 0 ? N : N - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dif; i++) {
            sb.append(left--).append(" ").append(right--).append(" ");
        }

        if (N % 2 != 0) sb.append(N);
        System.out.println(sb);
    }
}
