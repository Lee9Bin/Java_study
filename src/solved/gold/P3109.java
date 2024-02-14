package solved.gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3109 {
    static int R;
    static int C;
    static String[][] map;
    static boolean[][] visited;
    static int result;
    static boolean flag;
    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        result = 0;
        for (int i = 0; i < R; i ++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                map[i][j] = ch[j] + "";
            }
        }


        for (int i = 0; i < R; i++) {
            flag = false;
            find(i,0);
        }
        System.out.println(result);
    }

    public static void find(int x, int y) {
        if (y == C-1) {
            result += 1;
            flag = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C
                    && map[nextX][nextY].equals(".") && !visited[nextX][nextY] ) {
                visited[nextX][nextY] = true;
                find(nextX,nextY);
                if (flag) return;
            }
        }
    }
}
