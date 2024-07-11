package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] big = new int[N];
        int[] small = new int[N];
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(big, 1);

        int result = 1;

        for (int i = 0; i < N-1; i++){
            if (nums[i] <= nums[i+1]){
                big[i+1] = big[i] + 1;
                result = Math.max(result, big[i+1]);
            }
        }

        Arrays.fill(small, 1);

        for (int i = 0; i < N-1; i++){
            if (nums[i] >= nums[i+1]){
                small[i+1] = small[i] + 1;
                result = Math.max(result, small[i+1]);
            }
        }
        System.out.println(result);
    }
}
