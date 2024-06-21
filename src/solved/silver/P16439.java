package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] goris = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                goris[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int result = 0;
        for (int i = 0; i < M; i++){
            for (int j = i +1; j < M; j++){
                for (int k = j + 1; k < M; k++){
                    int[] chickens = new int[N];
                    for (int x = 0; x < N; x++){
                        chickens[x] = Math.max(chickens[x], goris[x][i]);
                        chickens[x] = Math.max(chickens[x], goris[x][j]);
                        chickens[x] = Math.max(chickens[x], goris[x][k]);
                    }
                    int total = 0;
                    for (int chicken : chickens) {
                        total += chicken;
                    }
                    result = Math.max(total, result);
                }
            }
        }
        System.out.println(result);
    }
}
