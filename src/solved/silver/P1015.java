package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] A = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            A[i] = new int[]{i, Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(A, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });

        int[] result = new int[n];

        for (int i = 0 ; i < n; i++){
            result[A[i][0]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
