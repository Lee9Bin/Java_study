package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int start = 0;
        int index = 0;

        while (true) {
            start++;

            String n = String.valueOf(start);

            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == num.charAt(index)) {
                    index++;
                }
                if (index == num.length()) {
                    System.out.println(start);
                    return;
                }

            }
        }
    }
}
