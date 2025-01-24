package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N - 1;
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (target <= nums[mid]) {
                    end = mid - 1;
                    if (nums[mid] == target) result = mid;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
