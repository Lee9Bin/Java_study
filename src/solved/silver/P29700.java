package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0 ; i < N; i ++){
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++){
                map[i][j] = ch[j] - '0';
            }
        }

        long result = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0){
                    int possible = 0;
                    for (int k = j ; k < j+K; k++){
                        if (k >= M) break;
                        if (map[i][k] == 0) possible +=1;
                    }
                    if (possible == K) result++;
                }
            }
        }
        System.out.println(result);
    }
}
