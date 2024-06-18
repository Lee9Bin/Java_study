package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] leakPoints = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            leakPoints[Integer.parseInt(st.nextToken())] = 1;
        }

        int result = 0;
        for (int i = 0; i < 10001; i++){
            if (leakPoints[i] == 1){
                result++;
                i += L-1;
            }
        }
        System.out.println(result);
    }
}
