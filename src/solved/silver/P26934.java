package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P26934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int target = num / 100;

        if (num % 100 != 0) {
            target++;
        }

        int[] coins = new int[]{5, 2, 1};

        int result = 0;

        for (int coin : coins) {
            result += target / coin;
            target %= coin;
        }

        System.out.println(result);

    }
}
