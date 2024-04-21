package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2567 {

    public static final int[] dx = {-1,0,1,0};
    public static final int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[101][101];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++){
                for (int k = y; k < y + 10; k++){
                    map[j][k] = 1;
                }
            }
        }

        int total = 0;
        for (int i = 0; i < 101; i++){
            for (int j = 0; j < 101; j++){
                if (map[i][j] == 1){
                    for (int k = 0; k < 4; k++){
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (nextX < 0 || nextX >= 101 || nextY < 0 || nextY >= 101) {
                            total ++;
                            continue;
                        }
                        if (map[nextX][nextY] == 0) total ++;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
