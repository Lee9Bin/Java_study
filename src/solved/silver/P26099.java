package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P26099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long result = 0;

        while (n % 5 != 0) {
            n -= 3;
            result++;
        }

        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result + n / 5);
        }
    }
}
