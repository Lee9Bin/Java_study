package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1949 {

    static int N;
    static int[] peoples;
    static boolean[] visited;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        peoples = new int[N];
        visited = new boolean[N+1];
        dp = new int[10001][2];
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            peoples[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int now){
        if (visited[now]){
            return;
        }

        visited[now] = true;
        dp[now][0] = 0;
        dp[now][1] = peoples[now-1];

        for (int nextTarget : graph.get(now)) {
            if (visited[nextTarget]) continue;
            dfs(nextTarget);
            dp[now][0] = dp[now][0] + Math.max(dp[nextTarget][0], dp[nextTarget][1]);
            dp[now][1] = dp[now][1] + dp[nextTarget][0];
        }


    }
}
