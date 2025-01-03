package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P32653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long result = 1;
        for (int i = 0; i < n; i++) {
            result = lcm(result, nums[i]);
        }
        System.out.println(2 * result);

    }

    public static long gdc(long a, long b) {
        if (a < b) {

            long temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return a * b / gdc(a, b);
    }
}
