package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] names = new String[n][2];

        for (int i = 0; i < n; i++) {
            names[i] = br.readLine().split(" ");
        }

        Arrays.sort(names, (String[] o1, String[] o2) -> {
            return !o1[1].equals(o2[1]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(names[i][0]).append(" ").append(names[i][1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
