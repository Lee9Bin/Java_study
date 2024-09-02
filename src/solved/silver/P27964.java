package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P27964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Boolean> check = new HashMap<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            String toping = st.nextToken();

            if (toping.length() >= 6) {
                String temp = toping.replace("Cheese", "*");
                if (temp.charAt(temp.length() - 1) == '*' && !check.containsKey(toping)) {
                    check.put(toping, true);
                }
            }
        }
        if (check.size() >= 4) System.out.println("yummy");
        else System.out.println("sad");
    }
}
