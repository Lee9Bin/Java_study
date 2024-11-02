package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9842 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> prime = new ArrayList<>();

        prime.add(2);
        int count = 0;
        for (int i = 3; i < Integer.MAX_VALUE; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prime.add(i);
                count++;
            }
            if (count == N) break;
        }

        System.out.println(prime.get(N - 1));


    }
}
