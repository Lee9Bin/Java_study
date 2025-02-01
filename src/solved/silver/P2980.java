package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] loads = new int[L + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            loads[D][0] = R;
            loads[D][1] = G;
        }

        int time = 0;
        int dist = 0;
        while (dist < L) {
            //[0] = R
            //[1] = G
            int[] info = loads[dist];

            if (info[0] == 0) {
                time++;
                dist++;
                continue;
            }

            int total = info[0] + info[1];
            int now = time % total;
            if (0 <= now && now < info[0]) {
                time += info[0] - now + 1;
            } else {
                time++;
            }
            dist++;
        }
        System.out.println(time);
    }
}
