package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P9575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] a = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] b = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) b[i] = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(br.readLine());
            int[] c = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) c[i] = Integer.parseInt(st.nextToken());

            HashSet<Integer> check = new HashSet<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < K; k++) {
                        int target = a[i] + b[j] + c[k];
                        if (luckCheck(target)) {
                            check.add(target);
                        }
                    }
                }
            }
            sb.append(check.size()).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean luckCheck(int target) {
        boolean flag = true;

        String s = String.valueOf(target);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '5' && s.charAt(i) != '8') flag = false;
        }

        return flag;
    }
}
