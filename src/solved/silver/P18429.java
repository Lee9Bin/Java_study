package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18429 {

    static int n, k, result;
    static int[] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(st.nextToken()) - k;
        }

        visited = new boolean[n];
        dfs(500, 0);
        System.out.println(result);
    }

    public static void dfs(int now, int cnt){
        if (now < 500){
            return;
        }
        if (cnt == n){
            result ++;
            return;
        }

        for (int i = 0 ; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(now + cost[i], cnt +1);
                visited[i] = false;
            }
        }
    }
}
