package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] keyboards = new String[N + 1][1000001];
        int[][] word = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            word[i] = new int[]{a, b};
            keyboards[a][b] = c;
        }

        Arrays.sort(word, (int[] o1, int[] o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = word[i][0];
            int time = word[i][1];
            sb.append(keyboards[num][time]);
        }
        System.out.println(sb);
    }
}
