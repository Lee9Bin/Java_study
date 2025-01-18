package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15905 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());
            info[i] = new int[]{count, penalty};
        }

        Arrays.sort(info, (int[] o1, int[] o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        });

        int point = info[4][0];
        int result = 0;
        for (int i = 5; i < N; i++) {
            if (point == info[i][0]) result++;
        }

        System.out.println(result);
    }
}
