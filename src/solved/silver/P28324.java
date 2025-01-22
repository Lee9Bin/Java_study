package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] speeds = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            speeds[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int now = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (now < speeds[i]) now += 1;
            else {
                now = speeds[i];
            }
            result += now;
        }
        System.out.println(result);
    }
}
