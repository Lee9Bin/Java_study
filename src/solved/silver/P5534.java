package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P5534 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Long> nums = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            nums.add(Long.parseLong(st.nextToken()));
        }

        nums.add(1L);
        while (nums.size() >= 3) {
            long a = nums.pollLast();
            long b = nums.pollLast();
            long c = nums.pollLast();

            nums.add(b * c + a);
            nums.add(b);
        }
        
        long a = nums.pollLast();
        long b = nums.pollLast();

        System.out.println(b - a + " " + b);
    }
}
