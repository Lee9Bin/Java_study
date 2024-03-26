package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4485 {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int n;
    static int map[][], coins[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (true){
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            map = new int[n][n];
            coins = new int[n][n];
            for (int[] ints : coins) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> hq = new PriorityQueue<>((int[] o1, int[] o2) ->{
                return o1[0] != o2[0] ? o1[0] - o2[0] : (o1[1] != o2[1] ? o1[1] - o2[1] :
                        o1[2]-o2[2]);
            });
            coins[0][0] = map[0][0];
            hq.add(new int[] {map[0][0],0,0});

            while (!hq.isEmpty()){
                int[] info = hq.poll();

                int coin = info[0];
                int x = info[1];
                int y = info[2];

                for (int i = 0 ; i < 4; i ++){
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if ( 0 <= nextX && nextX < n && 0 <= nextY && nextY < n){
                        int newCoin = coin + map[nextX][nextY];
                        if (coins[nextX][nextY] > newCoin){
                            coins[nextX][nextY] = newCoin;
                            hq.add(new int[] {newCoin, nextX, nextY});
                        }
                    }
                }

            }
            sb.append("Problem ").append(index++).append(": ").append(coins[n-1][n-1])
                    .append("\n");
        }
        System.out.println(sb);

    }
}
