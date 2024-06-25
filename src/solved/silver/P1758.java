package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++){
            order[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(order, Comparator.reverseOrder());

        long result = 0;

        for (int i = 0; i < n;i++){
            int cost = order[i] - i;
            if (cost > 0) result += order[i] - i;
        }
        System.out.println(result);
    }
}
