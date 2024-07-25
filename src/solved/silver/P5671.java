package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P5671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s == null) break;
            StringTokenizer st = new StringTokenizer(s);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            int result = 0;
            for (int i = N; i <= M; i++) {
                String num = String.valueOf(i);
                boolean flag = true;
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = 0; j < num.length(); j++) {
                    if (map.containsKey(num.charAt(j))) {
                        flag = false;
                        break;
                    } else {
                        map.put(num.charAt(j), 1);
                    }
                }
                if (flag) result++;
            }
            System.out.println(result);
        }
    }
}
