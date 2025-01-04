package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<ArrayDeque<Integer>> guitar = new ArrayList<>();
        for (int i = 0; i < P + 1; i++) {
            guitar.add(new ArrayDeque<>());
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> nowLine = guitar.get(line);

            if (nowLine.isEmpty()) {
                nowLine.add(now);
                result++;
                continue;
            }

            while (true) {
                if (nowLine.isEmpty()) {
                    nowLine.addLast(now);
                    result++;
                    break;
                }
                int top = nowLine.peekLast();
                if (top > now) {
                    nowLine.pollLast();
                    result++;
                } else {
                    if (top != now) {
                        nowLine.addLast(now);
                        result++;
                    }
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
