package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heap.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while (true) {
            if (heap.size() == 1) {
                // total += heap.poll();
                break;
            }

            int newCards = 0;
            newCards += heap.poll();
            newCards += heap.poll();
            total += newCards;
            heap.add(newCards);
        }
        System.out.println(total);
    }
}
