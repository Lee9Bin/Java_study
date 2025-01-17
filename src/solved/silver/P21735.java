package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21735 {

    static int N, M, result;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        result = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(-1, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int index, int time, int size) {
        if (time > M) return;

        result = Math.max(result, size);

        if (index + 1 < N) {
            dfs(index + 1, time + 1, size + nums[index + 1]);
        }
        if (index + 2 < N) {
            dfs(index + 2, time + 1, (size / 2) + nums[index + 2]);
        }
    }
}
