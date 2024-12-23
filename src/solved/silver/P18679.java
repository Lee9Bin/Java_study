package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P18679 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> dic = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] word = br.readLine().split(" = ");
            dic.put(word[0], word[1]);
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            String[] word = br.readLine().split(" ");

            for (int j = 0; j < k; j++) {
                sb.append(dic.get(word[j])).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
