package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalPen = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        int[] pens = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pens[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(pens);

        int count = 0;
        int total = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (total < totalPen) {
                count++;
                total += pens[i];
            } else break;
        }

        if (total >= totalPen) {
            System.out.println(count);
        } else System.out.println("STRESS");
    }
}
