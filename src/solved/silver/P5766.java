package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P5766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            HashMap<Integer, Integer> players = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (players.containsKey(num)) players.put(num, players.get(num) + 1);
                    else players.put(num, 1);
                }
            }

            int maxPoint = 0;
            for (Integer integer : players.keySet()) {
                maxPoint = Math.max(players.get(integer), maxPoint);
            }


            for (Integer integer : players.keySet()) {
                if (players.get(integer).equals(maxPoint)) players.put(integer, 0);
            }

            maxPoint = 0;
            for (Integer integer : players.keySet()) {
                maxPoint = Math.max(players.get(integer), maxPoint);
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (Integer integer : players.keySet()) {
                if (players.get(integer).equals(maxPoint)) result.add(integer);
            }
            result.sort((o1, o2) -> o1 - o2);


            for (Integer integer : result) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
