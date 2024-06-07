import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24484 {

    static int N, M, R, order;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited, orders;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N+1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> arrayList : graph) {
            Collections.sort(arrayList, (o1, o2)->o2-o1);
        }

        visited = new int[N+1];
        orders = new int[N+1];
        order = 1;
        Arrays.fill(visited, -1);
        dfs(R, 0);

        long result = 0;
        for (int i = 1; i < N+1; i++) {
            result += (long)visited[i] * orders[i];
        }
        System.out.println(result);
    }

    public static void dfs(int now, int cnt) {

        visited[now] = cnt;
        orders[now] = order;
        order++;
        for (int next : graph.get(now)) {
            if (visited[next] == -1) {
                dfs(next, cnt + 1);
            }
        }
    }
}
