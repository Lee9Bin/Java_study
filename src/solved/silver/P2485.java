package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        nums.sort(Integer::compare);
        ArrayList<Integer> diff = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            diff.add(nums.get(i + 1) - nums.get(i));
        }

        int result = diff.get(0);
        for (int i = 0; i < diff.size(); i++) {
            result = GCD(diff.get(i), result);
        }

        System.out.println((nums.get(N - 1) - nums.get(0)) / result - diff.size());

    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else {
            return GCD(b, (a % b));
        }
    }
}
