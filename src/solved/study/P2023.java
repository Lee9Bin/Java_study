package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2023 {
    static int[] nums;
    static int n;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[] {2,3,5,7};

        result = new StringBuilder();
        back(0,new StringBuilder());
        System.out.println(result);
    }

    public static void back(int cnt, StringBuilder sb) {
        if (cnt == n) {
            result.append(sb).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            sb.append(i);
            if (check(Integer.parseInt(sb.toString()))) {
                back(cnt + 1, sb);
            }
            sb.delete(sb.length()-1, sb.length());
        }
    }

    public static boolean check(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        for (int i = 2; i < Math.sqrt(num)+1; i++) {
            if (num % i == 0) {
                return false;
            }
        }


        return true;
    }

}
