package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            for (int i = (int) Math.sqrt(s.length()) - 1; i >= 0; i--) {
                for (int j = 0; j < Math.sqrt(s.length()); j++) {
                    sb.append(s.charAt(i + (j * (int) Math.sqrt(s.length()))));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
