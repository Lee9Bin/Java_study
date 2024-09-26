package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P3711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] students = new int[n];

            for (int j = 0; j < n; j++) {
                students[j] = Integer.parseInt(br.readLine());
            }

            int result = 1;
            for (int j = 1; j < 100000; j++) {
                ArrayList<Integer> check = new ArrayList<Integer>();
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (check.contains(students[k] % j)) {
                        flag = false;
                        break;
                    } else {
                        check.add(students[k] % j);
                    }

                }
                if (flag) {
                    result = j;
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
