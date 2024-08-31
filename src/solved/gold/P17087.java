package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        int result = nums[0];
        for (int i = 0; i < N; i++) {
            result = GCD(result, nums[i]);
        }
        System.out.println(result);

    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}
