package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P14562 {

    static final int[] points = {0, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{S, T, 0});

            int result = Integer.MAX_VALUE;
            while (!deque.isEmpty()) {
                int[] now = deque.pollFirst();

                if (now[0] == now[1]) {
                    result = Math.min(result, now[2]);
                }

                if (2 * now[0] <= now[1] + 3) {
                    deque.add(new int[]{2 * now[0], now[1] + 3, now[2] + 1});
                }
                if (now[0] + 1 <= now[1]) {
                    deque.add(new int[]{now[0] + 1, now[1], now[2] + 1});
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
