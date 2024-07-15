package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            int total = 0;
            int[][] peoples = new int[n][2];
            for (int i = 0; i < n; i++){
                int count = Integer.parseInt(br.readLine());
                peoples[i] = new int[] {i+1, count};
                total += count;
            }

            Arrays.sort(peoples, (int[] o1, int[] o2)->{
                return o1[1] - o2[1];
            });

            if (peoples[n-1][1] == peoples[n-2][1]) {
                System.out.println("no winner");
                continue;
            }
            else {
                if (peoples[n-1][1] > total/2){
                    System.out.println("majority winner " + peoples[n-1][0]);
                }
                else {
                    System.out.println("minority winner " + peoples[n-1][0]);
                }
            }
        }
    }
}
