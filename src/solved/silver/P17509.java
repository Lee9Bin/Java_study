package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int time = 0;
        int[][] pro = new int[11][2];
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            pro[i][0] = Integer.parseInt(st.nextToken());
            pro[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(pro, (int[] o1, int[] o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        for (int i = 0; i < 11; i++) {
            time += pro[i][0];
            result += time + (20 * pro[i][1]);
        }
        System.out.println(result);
    }
}
