package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P23757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> presents = new PriorityQueue<>((a, b) -> b - a);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            presents.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int result = 1;
        for (int i = 0; i < M; i++) {
            int chill = Integer.parseInt(st.nextToken());
            if (!presents.isEmpty()) {
                int now = presents.poll();
                if (now >= chill) {
                    presents.add(now - chill);
                } else {
                    result = 0;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
