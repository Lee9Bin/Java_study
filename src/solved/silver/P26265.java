package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P26265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            result.add(new String[]{st.nextToken(), st.nextToken()});
        }

        result.sort((String[] o1, String[] o2) -> {
            return !o1[0].equals(o2[0]) ? o1[0].compareTo(o2[0]) : -o1[1].compareTo(o2[1]);
        });


        StringBuilder sb = new StringBuilder();
        for (String[] strings : result) {
            sb.append(strings[0]).append(" ").append(strings[1]).append("\n");
        }
        System.out.println(sb);
    }
}
