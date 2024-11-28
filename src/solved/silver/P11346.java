package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P11346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            Set<String> names = new HashSet<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < first; i++) {
                names.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < second; i++) {
                names.add(st.nextToken());
            }
            sb.append(names.size()).append("\n");
        }
        System.out.println(sb);
    }
}
