package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P25496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] accessories = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            accessories[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(accessories);

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (P >= 200) break;
            result++;
            P += accessories[i];
        }
        System.out.println(result);
    }
}
