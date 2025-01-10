package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P25370 {

    static Set<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        result = new HashSet<>();
        dfs(0, N, 1);

        System.out.println(result.size());
    }

    public static void dfs(int nowDepth, int maxDepth, int value) {
        if (nowDepth == maxDepth) {
            result.add(value);
            return;
        }

        for (int i = 1; i < 10; i++) {
            dfs(nowDepth + 1, maxDepth, value * i);
        }
    }
}
