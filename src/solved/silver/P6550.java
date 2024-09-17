package solved.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String temp = br.readLine();
            if (temp == null) break;
            StringTokenizer st = new StringTokenizer(temp);
            String s = st.nextToken();
            String t = st.nextToken();

            int index = 0;

            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(index) == t.charAt(i)) index++;
                if (index == s.length()) break;
            }

            if (index == s.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
