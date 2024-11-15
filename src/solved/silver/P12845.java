package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>((Integer o1, Integer o2) -> {
            return o2 - o1;
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }


        int result = 0;
        while (cards.size() != 1) {
            int first = cards.poll();
            int second = cards.poll();

            result += (first + second);

            cards.add(first);
        }
        System.out.println(result);
    }
}
