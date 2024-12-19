package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P1835 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(N);

        for (int i = N - 1; i > 0; i--) {
            deque.addFirst(i);

            for (int j = 0; j < i; j++) {
                int card = deque.pollLast();
                deque.addFirst(card);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : deque) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
