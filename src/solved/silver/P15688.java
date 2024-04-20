package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P15688 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            heap.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        while (!heap.isEmpty()) sb.append(heap.poll()).append("\n");

        System.out.println(sb);
    }
}
