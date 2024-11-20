package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] speeds = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int spot = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            speeds[i] = speed;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            int speed = speeds[i];
            if (stack.isEmpty() || stack.peek() >= speed) {
                stack.push(speed);
            }
        }
        System.out.println(stack.size());
    }
}
