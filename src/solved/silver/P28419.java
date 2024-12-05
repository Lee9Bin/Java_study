package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int odds = 0;
        int evens = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) evens += Integer.parseInt(st.nextToken());
            else odds += Integer.parseInt(st.nextToken());
        }

        if (n == 3 && evens < odds) System.out.println(-1);
        else {
            if (evens > odds) System.out.println(evens - odds);
            else {
                System.out.println(odds - evens);
            }
        }
    }
}
