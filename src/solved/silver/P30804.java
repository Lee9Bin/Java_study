package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tangs = new int[n];

        for (int i = 0; i < n; i++) {
            tangs[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int left = 0;
        int kinds = 0;
        int[] count = new int[10];

        for (int right = 0; right < n; right++) {
            if (count[tangs[right]] == 0) {
                kinds++;
            }
            count[tangs[right]]++;

            while (kinds > 2) {
                count[tangs[left]]--;
                if (count[tangs[left]] == 0) {
                    kinds--;
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
}
