package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] sticks = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < n; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
            total += sticks[i];
        }

        Arrays.sort(sticks);
        long result = 0;
        for (int i = 0; i < n; i++) {
            total -= sticks[i];
            result += total * sticks[i];
        }
        System.out.println(result);
    }
}
