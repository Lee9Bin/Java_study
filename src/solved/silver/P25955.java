package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P25955 {

    static class Problem {

        String tierName;
        int tier;
        int step;

        public Problem(String tierName, int tier, int step) {
            this.tierName = tierName;
            this.tier = tier;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        ArrayList<Problem> origin = new ArrayList<>();
        ArrayList<Problem> sorted = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp = st.nextToken();
            char tier = temp.charAt(0);
            int step = Integer.parseInt(temp.substring(1));
            Problem problem = new Problem(String.valueOf(tier), calculateTier(tier), step);
            origin.add(problem);
            sorted.add(problem);
        }

        sorted.sort((Problem p1, Problem p2) -> {
            return p1.tier != p2.tier ? p1.tier - p2.tier : p2.step - p1.step;
        });

        ArrayList<Problem> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (origin.get(i).tier != sorted.get(i).tier || origin.get(i).step != sorted.get(i).step) {
                result.add(origin.get(i));
            }
        }

        if (result.size() == 0) System.out.println("OK");
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("KO").append("\n");
            result.sort((Problem p1, Problem p2) -> {
                return p1.tier != p2.tier ? p1.tier - p2.tier : p2.step - p1.step;
            });
            for (Problem problem : result) {
                sb.append(problem.tierName).append(problem.step).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static int calculateTier(char tier) {
        if (tier == 'B') return 1;
        else if (tier == 'S') return 2;
        else if (tier == 'G') return 3;
        else if (tier == 'P') return 4;
        else return 5;
    }
}
