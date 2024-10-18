package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] homes = new int[N];

        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int start = 1;
        int end = homes[N - 1] - homes[0];

        int[] diff = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            diff[i] = homes[i + 1] - homes[i];
        }

        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            // System.out.println("start = " + start);
            // System.out.println("end = " + end);
            // System.out.println("mid = " + mid);
            int count = 0;
            int now = 0;
            for (int i = 0; i < N - 1; i++) {
                if (now + diff[i] < mid) {
                    now += diff[i];
                } else {
                    count += 1;
                    now = 0;
                }
            }

            if (now >= mid) count++;

            if (count < C - 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.println(result);
    }
}
