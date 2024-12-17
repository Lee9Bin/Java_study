package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> slimes = new PriorityQueue<>((Integer o1, Integer o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < N; i++) {
            slimes.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (slimes.size() > 1) {
            int first = slimes.poll();
            int second = slimes.poll();
            result += first * second;

            slimes.add(first + second);
        }

        System.out.println(result);
    }
}
