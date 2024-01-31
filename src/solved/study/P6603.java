package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6603 {
    static StringBuilder sb;

    static int n;
    static int[] nums;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 1) {
                break;
            }
            n = Integer.parseInt(st.nextToken());
            nums = new int[n];
            result = new int[6];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void lotto(int start, int cnt){
        if (cnt == 6){
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++){
            result[cnt] = nums[i];
            lotto(i+1,cnt+1);
        }
    }
}
