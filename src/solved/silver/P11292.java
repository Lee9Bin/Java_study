package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class P11292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            ArrayList<String[]> peoples = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String height = st.nextToken();
                peoples.add(new String[]{name, height});
            }

            peoples.sort((String[] o1, String[] o2) -> {
                return Double.compare(Double.parseDouble(o2[1]), Double.parseDouble(o1[1]));
            });

            for (String[] people : peoples) {
                if (Objects.equals(peoples.get(0)[1], people[1])) sb.append(people[0]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
