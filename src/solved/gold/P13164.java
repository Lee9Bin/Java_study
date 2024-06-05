package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] students = new int[n];

        for (int i = 0; i < n ; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[n-1];
        for (int i = 0; i < n-1; i++){
            diff[i] = students[i+1] - students[i];
        }

        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < n-K; i++)result += diff[i];
        System.out.println(result);
    }

}
