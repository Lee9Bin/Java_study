package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tests = 0 ; tests < t; tests++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] size = new int[N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                size[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(size);

            int result = 0;
            int count = 0;
            for (int i = N-1; i >= 0; i--){
                result ++;
                if (count + size[i] >= j){
                    break;
                }
                else{
                    count += size[i];
                }
            }

            System.out.println(result);
        }
    }
}
