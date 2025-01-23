package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P23305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] students = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            students[Integer.parseInt(st.nextToken())] += 1;
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (students[num] >= 1) {
                students[num] -= 1;
            } else {
                result += 1;
            }
        }

        System.out.println(result);
    }
}
