package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Boolean> dance = new HashMap<>();

        dance.put("ChongChong", true);

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (!dance.containsKey(a) && !dance.containsKey(b)) continue;

            dance.put(a, true);
            dance.put(b, true);
        }

        System.out.println(dance.size());
    }
}
