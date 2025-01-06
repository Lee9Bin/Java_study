package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P5107 {

    static int result;
    static HashMap<String, String> names;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            result = 0;
            if (N == 0) break;

            names = new HashMap<>();
            visited = new HashSet<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();

                names.put(from, to);
            }


            for (String name : names.keySet()) {
                if (!visited.contains(name)) {
                    visited.add(name);
                    dfs(names.get(name), name);
                }
            }

            sb.append(count).append(" ").append(result).append("\n");
            count++;
        }
        System.out.println(sb);
    }

    public static void dfs(String name, String start) {

        if (name.equals(start)) {
            result++;
            return;
        }


        visited.add(name);
        dfs(names.get(name), start);
    }
}
