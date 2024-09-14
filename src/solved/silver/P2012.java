package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] students = new int[N];

        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(students);

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(students[i] - (i + 1));
        }
        System.out.println(result);
    }
}
