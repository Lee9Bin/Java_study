package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] info = new int[N];
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                info[i] = now;
                if (!count.containsKey(now)) {
                    count.put(now, 1);
                } else {
                    count.put(now, count.get(now) + 1);
                }
            }


            HashMap<Integer, ArrayList<Integer>> team = new HashMap<>();
            int rank = 1;
            for (int i = 0; i < N; i++) {
                int now = info[i];
                if (count.get(now) == 6) {
                    if (!team.containsKey(now)) {
                        ArrayList<Integer> newTeam = new ArrayList<>();
                        newTeam.add(rank);
                        team.put(now, newTeam);
                    } else {
                        ArrayList<Integer> oldTeam = team.get(now);
                        oldTeam.add(rank);
                        team.put(now, oldTeam);
                    }
                    rank++;
                }
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (Integer integer : team.keySet()) {
                int total = 0;
                ArrayList<Integer> nowTeam = team.get(integer);
                for (int i = 0; i < 4; i++) {
                    total += nowTeam.get(i);
                }
                nowTeam.add(total);
                nowTeam.add(integer);
                result.add(nowTeam);
            }

            Collections.sort(result, (ArrayList<Integer> o1, ArrayList<Integer> o2) -> {
                return !o1.get(6).equals(o2.get(6)) ? o1.get(6) - o2.get(6) : o1.get(4) - o2.get(4);
            });
            System.out.println(result.get(0).get(7));
        }
    }
}
