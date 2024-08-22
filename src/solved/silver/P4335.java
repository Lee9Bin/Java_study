package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 0;
        int end = 11;
        int n;
        StringBuilder sb = new StringBuilder();
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String command = br.readLine();

            if (command.equals("too high") && n < end) {
                end = n;
            } else if (command.equals("too low") && start < n) {
                start = n;
            } else if (command.equals("right on")) {
                if (start >= n || end <= n) {
                    sb.append("Stan is dishonest").append("\n");
                } else {
                    sb.append("Stan may be honest").append("\n");
                }
                start = 0;
                end = 11;
            }
        }
        System.out.println(sb);
    }
}
