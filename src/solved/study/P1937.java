    package solved.study;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class P1937 {

        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};

        static int N, result;
        static int[][] map;
        static int[][] dp;

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = Math.max(result, dfs(i,j));
                }
            }
            System.out.println(result);
        }

        public static int dfs(int x, int y) {

            if(dp[x][y] != 0){
                return dp[x][y];
            }

            dp[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if ( 0<= nextX && nextX < N && 0 <= nextY && nextY < N && map[x][y] < map[nextX][nextY]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nextX, nextY) + 1);
                }
            }
            return dp[x][y];
        }
    }
