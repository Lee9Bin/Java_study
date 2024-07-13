package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int order = 1;
        for (int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());
            stack.add(now);

            while (stack.peekLast() == order){
                stack.pollLast();
                order++;
                if(stack.isEmpty()) break;
            }
        }

        if (stack.size() == 0) {
            System.out.println("Nice");
        }
        else{
            System.out.println("Sad");
        }
    }
}
