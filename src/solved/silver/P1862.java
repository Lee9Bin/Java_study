package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int length = String.valueOf(n).length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            int digit = n % 10;
            n = n / 10;

            if (digit > 4) {
                result += (digit - 1) * Math.pow(9, i);
            } else {
                result += digit * Math.pow(9, i);
            }
        }

        System.out.println(result);
    }
}
