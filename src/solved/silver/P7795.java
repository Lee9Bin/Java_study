package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < tests; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++){
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);
            sb.append(eat(A, B)).append("\n");

        }
        System.out.println(sb);
    }

    public static int eat(int[] A, int[] B){

        int result = 0;

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (A[i] > B[j]) result++;
                else break;
            }
        }

        return result;
    }
}
