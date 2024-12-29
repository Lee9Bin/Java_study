package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < N; t++) {
            String[] sounds = br.readLine().split(" ");

            HashMap<String, Boolean> result = new HashMap<>();
            for (String sound : sounds) {
                result.put(sound, true);
            }

            while (true) {
                String temp = br.readLine();
                if (temp.equals("what does the fox say?")) {
                    break;
                }
                String sound = temp.split(" ")[2];

                result.put(sound, false);
            }

            for (String sound : sounds) {
                if (result.get(sound)) sb.append(sound).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
