package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 1;
        int box = M;
        if (N > 0){
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++){
                int now = Integer.parseInt(st.nextToken());
                if (box < now){
                    result++;
                    box = M - now;
                }
                else{
                    box -= now;
                }
            }
            System.out.println(result);
        }
        else{
            System.out.println(0);
        }
    }
}
