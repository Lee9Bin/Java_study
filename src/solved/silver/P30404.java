package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P30404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int last = 0;
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int duck = Integer.parseInt(st.nextToken());

            if (i == 0) last = duck;

            if (last + K < duck) {
                cnt++;
                last = duck;
            }
        }

        System.out.println(cnt + 1);
    }
}