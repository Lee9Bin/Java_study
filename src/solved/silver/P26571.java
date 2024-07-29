package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P26571 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        if (a * K + b == c * K + d) System.out.println("Yes" + " " + (a * K + b));
        else System.out.println("No");

    }
}
