package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P6752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] nums = new int[C];

        for (int i = 0; i < C; i++) nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int time = 0;
        int result = 0;
        for (int num : nums) {
            if (time + num <= T) {
                time += num;
                result++;
            }
        }
        System.out.println(result);
    }
}
