package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> words = new HashMap<>();
        for (int i = 0; i < N; i++) {
            words.put(br.readLine(), true);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] remove = br.readLine().split(",");

            for (String r : remove) {
                if (words.containsKey(r)) words.remove(r);
            }
            sb.append(words.size()).append("\n");
        }

        System.out.println(sb);
    }
}
