package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }

        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        int weight = 0; // 현재 하중
        int count = 0; // 건너간 트럭수

        for (int i = 0; i < w; i++) bridge.add(0);

        int time = 0;
        while (count < n) {
            time++;
            int outTruck = bridge.pollFirst();

            if (outTruck != 0) {
                count++;
                weight -= outTruck;
            }

            if (!deque.isEmpty()) {

                int now = deque.pollFirst();

                if (weight + now <= l) {
                    bridge.add(now);
                    weight += now;
                } else {
                    deque.addFirst(now);
                    bridge.add(0);
                }
            } else bridge.add(0);
        }
        System.out.println(time);
    }
}
