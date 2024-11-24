package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P3182 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            graph.get(i).add(num);
        }

        int student = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            count = 0;
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i);
            if (result < count) {
                student = i;
                result = count;
            }
        }

        System.out.println(student);
    }

    public static void dfs(int target) {

        for (int next : graph.get(target)) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                dfs(next);
            }
        }
    }
}
