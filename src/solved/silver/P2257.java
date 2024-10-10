package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class P2257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('H', 1);
        dic.put('C', 12);
        dic.put('O', 16);


        int result = 0;

        for (int i = 0; i < formula.length(); i++) {
            char now = formula.charAt(i);
            if (now == 'H' || now == 'C' || now == 'O') {
                deque.addLast(dic.get(now));
            } else if (now == '(') deque.addLast(-1);
            else if (now == ')') {
                int cost = 0;
                while (!deque.isEmpty()) {
                    int temp = deque.pollLast();
                    if (temp == -1) break;
                    cost += temp;
                }
                if (cost != 0) deque.addLast(cost);
            } else {
                deque.add(deque.pollLast() * (now - '0'));
            }
        }
        while (!deque.isEmpty()) result += deque.pollLast();

        System.out.println(result);
    }
}

