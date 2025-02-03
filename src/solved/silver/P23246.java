package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P23246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] players = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            players[i][0] = b;
            players[i][1] = p * q * r;
            players[i][2] = p + q + r;
        }

        Arrays.sort(players, (int[] o1, int[] o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[2] != o2[2] ? o1[2] - o2[2] : o1[0] - o2[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(players[i][0]).append(" ");
        }
        System.out.println(sb);
    }
}
