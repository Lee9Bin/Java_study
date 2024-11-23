package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P7596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int track = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            ArrayList<String> mp3 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                mp3.add(br.readLine());
            }
            Collections.sort(mp3);

            sb.append(track++).append("\n");
            for (String sing : mp3) {
                sb.append(sing).append("\n");
            }
        }
        System.out.println(sb);
    }
}
