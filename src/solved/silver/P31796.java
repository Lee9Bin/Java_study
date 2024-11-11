package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P31796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] books = new int[N];

        for (int i = 0; i < N; i++) books[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(books);

        int result = 1;

        int now = books[0];
        for (int i = 1; i < N; i++) {
            if (now * 2 <= books[i]) {
                result++;
                now = books[i];
            }
        }
        System.out.println(result);
    }
}
