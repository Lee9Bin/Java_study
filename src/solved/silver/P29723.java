package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P29723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> lectures = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int down = 0;
        int up = 0;
        for (int i = 0; i < K; i++) {
            String name = br.readLine();
            down += lectures.get(name);
            up += lectures.get(name);
            lectures.remove(name);
        }

        ArrayList<Integer> remain = new ArrayList<>();
        for (String s : lectures.keySet()) {
            remain.add(lectures.get(s));
        }

        Collections.sort(remain);

        for (int i = 0; i < M - K; i++) {
            down += remain.get(i);
            up += remain.get(remain.size() - 1 - i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(down).append(" ").append(up);
        System.out.println(sb);

    }
}
