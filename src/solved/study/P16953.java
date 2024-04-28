package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Long.compare(o1[0], o2[0]);
            } else {
                return Long.compare(o2[1], o1[1]);
            }
        });

        heap.add(new long[]{1, a * 2});
        heap.add(new long[]{1, a * 10 + 1});


        long result = -1;
        while (!heap.isEmpty()) {
            long[] info = heap.poll();

            if (info[1] == b) {
                result = info[0] + 1;
                break;
            }

            if (info[1] * 2 <= b) heap.add(new long[]{info[0] + 1, info[1] * 2});
            if (info[1] * 10 + 1 <= b) heap.add(new long[]{info[0] + 1, info[1] * 10 + 1});

        }

        System.out.println(result);
    }


}
