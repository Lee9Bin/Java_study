package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String me = br.readLine();
        String she = br.readLine();

        int[] count = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        int[] plus = new int[me.length() + she.length()];

        for (int i = 0; i < plus.length - 1; i += 2) {
            plus[i] = count[me.charAt(i / 2) - 65];
            plus[i + 1] = count[she.charAt(i / 2) - 65];

        }

        int size = plus.length;
        while (size > 2) {
            for (int i = 0; i < size - 1; i++) {
                plus[i] = (plus[i] + plus[i + 1]) % 10;
            }
            plus[--size] = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(plus[0]);
        sb.append(plus[1]);
        System.out.println(sb);

    }
}
