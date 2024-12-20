package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] matryoshkas = new int[N];
        for (int i = 0; i < N; i++) {
            matryoshkas[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(matryoshkas);

        int result = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                result++;
                visited[i] = true;
                int now = matryoshkas[i];
                for (int j = i + 1; j < N; j++) {
                    if (!visited[j] && now < matryoshkas[j]) {
                        visited[j] = true;
                        now = matryoshkas[j];
                    }
                }
            }
        }
        System.out.println(result);
    }
}
