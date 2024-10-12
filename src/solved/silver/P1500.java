package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long div = S / K;
        long mod = S % K;

        long result = 1;
        for (int i = 1; i <= K; i++) {
            if (i <= mod) {
                result *= (div + 1);
            } else {
                result *= div;
            }
        }
        System.out.println(result);
    }
}
