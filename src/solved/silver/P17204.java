package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] students = new int[N];

        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[N];
        int start = 0;
        int count = 0;
        visited[start] = true;
        while (true) {
            int now = students[start];

            if (visited[now]) {
                System.out.println(-1);
                break;
            }

            if (now == K) {
                System.out.println(count + 1);
                return;
            }

            visited[now] = true;
            count++;
            start = now;
        }
    }
}
