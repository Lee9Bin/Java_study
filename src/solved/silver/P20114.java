package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());


        char[][] graph = new char[H][N*W];

        for (int i = 0; i <  H; i++){
            String s = br.readLine();
            for (int j = 0; j < N*W; j++){
                graph[i][j] = s.charAt(j);
            }

        }


        StringBuilder sb = new StringBuilder();
        char now = '?';
        for (int i = 0; i <  N * W; i++){
            for (int j = 0; j < H; j++){
                if (graph[j][i] != '?'){
                    now = graph[j][i];
                }
            }
            if (i % W == W-1){
                sb.append(now);
                now = '?';
            }

        }
        System.out.println(sb);

    }
}
