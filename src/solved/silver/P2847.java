package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] levels = new int[n];

        for (int i = 0 ; i< n; i++){
            levels[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        int now = levels[n-1];
        for (int i = n-2; i >= 0; i--){
            while (levels[i] >= now){
                total ++;
                levels[i] --;
            }
            now = levels[i];
        }

        System.out.println(total);
    }
}
