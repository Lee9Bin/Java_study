package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Long result = 1L;

        for (int i = num - 1; i >= 1; i -= 2) {
            result = (result * i) % 1000000007;
        }
        System.out.println(result);

    }
}

