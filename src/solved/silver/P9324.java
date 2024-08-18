package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            String word = br.readLine();

            boolean flag = true;
            HashMap<Character, Integer> info = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                char now = word.charAt(i);
                if (!info.containsKey(now)) {
                    info.put(now, 1);
                } else {
                    info.put(now, info.get(now) + 1);
                    if (info.get(now) == 3) {
                        i++;
                        if (i >= word.length() || word.charAt(i) != now) {
                            flag = false;
                            break;
                        }
                        info.put(now, 0);
                    }
                }
            }
            if (flag) sb.append("OK").append("\n");
            else sb.append("FAKE").append("\n");
        }
        System.out.println(sb);
    }
}
