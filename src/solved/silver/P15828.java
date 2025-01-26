package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == -1) break;

            if (num == 0) deque.poll();
            else if (N > deque.size()) deque.addLast(num);
        }

        if (deque.isEmpty()) System.out.println("empty");
        else {
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(" ");
            }

            System.out.println(sb);
        }
    }
}
