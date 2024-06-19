package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5212 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int startR = R;
        int endR = 0;
        int startC = C;
        int endC = 0;

        char[][] map = new char[R][C];

        for (int i = 0; i < R; i ++){
            map[i] = br.readLine().toCharArray();
        }

        int[][] count = new int[R][C];

        for(int i = 0 ; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] == 'X'){
                    int water = 0;
                    for (int k = 0; k < 4; k ++){
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if ( nextX < 0 || R <= nextX || nextY < 0 || C <= nextY ) {
                            water ++;
                            continue;
                        }
                        if (map[nextX][nextY] == '.') water++;
                    }
                    count[i][j] = water;
                }
            }
        }

        for(int i = 0 ; i < R; i++){
            for (int j = 0; j < C; j++){
                if(count[i][j] >= 3) map[i][j] = '.';
                if (map[i][j] == 'X'){
                    startR = Math.min(i, startR);
                    startC = Math.min(j, startC);
                    endR = Math.max(i, endR);
                    endC = Math.max(j, endC);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = startR; i <= endR; i++){
            for (int j = startC; j <= endC; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

