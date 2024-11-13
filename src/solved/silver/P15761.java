package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cows = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cows);

        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (cows[i] >= result) result++;
        }
        System.out.println(result);
    }
}
