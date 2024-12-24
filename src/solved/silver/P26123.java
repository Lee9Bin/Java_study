package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P26123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] height = new int[300001];
        int maxHeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            height[now] += 1;
            maxHeight = Math.max(maxHeight, now);
        }

        long result = 0;
        for (int i = 0; i < D; i++) {
            if (maxHeight == 0) break;
            int count = height[maxHeight];
            result += count;
            height[maxHeight - 1] += count;
            maxHeight -= 1;
        }
        System.out.println(result);
    }
}
