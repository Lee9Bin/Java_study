package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P19605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        char[] word = br.readLine().toCharArray();

        for (int i = 0; i < word.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + word.length; j++) {
                sb.append(word[j % word.length]);
            }
            if (target.contains(sb)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");

    }
}
