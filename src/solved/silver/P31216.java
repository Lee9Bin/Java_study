package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P31216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[318138];
        num[1] = 1;

        for (int i = 2; i < 318138; i++) {
            if (num[i] != 1) {
                for (int j = i + i; j < 318138; j += i) {
                    num[j] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int order = 1;
        for (int i = 2; i < 318138; i++) {
            if (num[i] == 0) {
                if (num[order] == 0) result.add(i);
                order++;
            }
        }


        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(result.get(Integer.parseInt(br.readLine()) - 1)).append("\n");
        }
        System.out.println(sb);
    }
}
