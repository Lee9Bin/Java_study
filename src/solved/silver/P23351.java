package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P23351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> catLeafs = new PriorityQueue<>();

        for (int i = 0; i < N; i++) catLeafs.add(K);

        int result = 0;
        while (true) {
            result++;
            for (int i = 0; i < A; i++) {
                catLeafs.add(catLeafs.poll() + B);
            }

            int now = catLeafs.peek();
            if (now - result == 0) break;
        }
        System.out.println(result);
    }
}
