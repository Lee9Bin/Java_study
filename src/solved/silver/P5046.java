package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            int cost = Integer.parseInt(br.readLine());
            int total = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                int count = Integer.parseInt(st.nextToken());
                if (count >= N) total = cost * N;
            }

            if (total <= B) result = Math.min(result, total);

        }

        if (result == Integer.MAX_VALUE) System.out.println("stay home");
        else System.out.println(result);
    }
}
