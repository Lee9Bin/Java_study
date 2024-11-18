package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P23561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[3 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3 * n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int i = n; i < n + n; i++) {
            result.add(nums[i]);
        }

        System.out.println(result.peekLast() - result.peekFirst());


    }
}
