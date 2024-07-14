package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] homes = new int[N];

        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homes);

        if (N % 2 == 0){
            System.out.println(homes[N/2-1]);
        }
        else{
            System.out.println(homes[N/2]);
        }
    }

}
