package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P29719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 전체 경우의 수
        long all = 1;
        for (int i = 0; i < N; i++) {
            all *= M;
            all %= 1000000007;
        }

        long div = 1;
        for (int i = 0; i < N; i++) {
            div *= (M - 1);
            div %= 1000000007;
        }

        System.out.println((all - div + 1000000007) % 1000000007);
    }
}
