package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;

        int B = Integer.parseInt(st.nextToken());
        min = Math.min(B, min);
        int C = Integer.parseInt(st.nextToken());
        min = Math.min(C, min);
        int D = Integer.parseInt(st.nextToken());
        min = Math.min(D, min);

        Integer[][] list = new Integer[3][];
        list[0] = new Integer[B];
        list[1] = new Integer[C];
        list[2] = new Integer[D];

        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++){
            list[0][i] = Integer.parseInt(st.nextToken());
            total += list[0][i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            list[1][i] = Integer.parseInt(st.nextToken());
            total += list[1][i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++){
            list[2][i] = Integer.parseInt(st.nextToken());
            total += list[2][i];
        }

        for (Integer[] ints : list) {
            Arrays.sort(ints, (o1, o2) -> o2 - o1);
        }


        int result = total;
        for (int i = 0; i < min; i++){
            int sub = 0;
            sub += list[0][i];
            sub += list[1][i];
            sub += list[2][i];
            result -= sub;
            result += sub * 0.9;
        }
        System.out.println(total);
        System.out.println(result);
    }
}
