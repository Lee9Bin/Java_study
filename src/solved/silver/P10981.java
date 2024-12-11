package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10981 {

    static class Team {
        String name;
        int count;
        int penalty;

        public Team(String name, int count, int penalty) {
            this.name = name;
            this.count = count;
            this.penalty = penalty;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, PriorityQueue<Team>> universities = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String school = st.nextToken();
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());

            PriorityQueue<Team> teams;
            if (universities.containsKey(school)) {
                teams = universities.get(school);
            } else {
                teams = new PriorityQueue<>((Team t1, Team t2) -> {
                    return t2.count != t1.count ? t2.count - t1.count : t1.penalty - t2.penalty;
                });
            }
            teams.add(new Team(name, count, penalty));
            universities.put(school, teams);
        }

        PriorityQueue<Team> result = new PriorityQueue<>((Team t1, Team t2) -> {
            return t2.count != t1.count ? t2.count - t1.count : t1.penalty - t2.penalty;
        });
        for (String school : universities.keySet()) {
            PriorityQueue<Team> teams = universities.get(school);
            result.add(teams.poll());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) sb.append(result.poll().name).append("\n");
        System.out.println(sb);
    }
}
