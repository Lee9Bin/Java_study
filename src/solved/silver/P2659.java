package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2659 {

    static int[] nums;
    static int num;
    static ArrayList<int[]> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            num = 0;
            sumNums(0, 0, 0);
            result.add(new int[]{i + 1, num});
        }

        result.sort((int[] o1, int[] o2) -> {
            return o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];
        });

        System.out.println(result.get(0)[0]);


    }

    public static void sumNums(int index, int total, int cnt) {
        if (cnt == 3) {
            num = Math.max(num, total % 10);
            return;
        }

        for (int i = index; i < 5; i++) {
            sumNums(i + 1, total + nums[i], cnt + 1);
        }
    }
}
