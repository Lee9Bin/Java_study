package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Long> result = new ArrayList<>();

        int count = st.countTokens();
        for (int i = 0; i < count; i++) {
            String num = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num.length(); j++) {
                sb.append(num.charAt(j));
            }
            sb.reverse();
            result.add(Long.parseLong(sb.toString()));
        }

        while (count != N) {
            st = new StringTokenizer(br.readLine());
            int temp = st.countTokens();
            count += st.countTokens();

            for (int i = 0; i < temp; i++) {
                String num = st.nextToken();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num.length(); j++) {
                    sb.append(num.charAt(j));
                }
                sb.reverse();
                result.add(Long.parseLong(sb.toString()));
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (Long integer : result) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
    }
}
