package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P30088 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                time[i] += Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(time);
        Long result = 0L;
        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += time[i];
            result += sum;
        }
        System.out.println(result);
    }
}
