package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P30923 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] height = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            // 앞 뒤
            result += 2 * height[i];
        }
        // 윗면 아랫면
        result += 2L * n;
        // 맨 왼쪽 맨 오를쪽
        result += height[0] + height[n - 1];

        for (int i = 0; i < n - 1; i++) {
            result += Math.abs(height[i] - height[i + 1]);
        }

        System.out.println(result);
    }
}
