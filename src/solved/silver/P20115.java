package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Double> heapq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heapq.add(Double.parseDouble(st.nextToken()));
        }

        double amount = 0;
        while (heapq.size() > 1) {
            double a = heapq.poll();
            amount += a / 2;

        }

        System.out.println(heapq.poll() + amount);
    }
}
