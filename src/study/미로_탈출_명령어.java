package study;

import java.util.Arrays;
import java.util.HashMap;

public class 미로_탈출_명령어 {

    static final int[] dx = { 1, 0, 0, -1 };
    static final int[] dy = { 0, -1, 1, 0 };
    static HashMap<Integer, String> hashMap;
    static char[][] map;
    static StringBuilder sb;
    static boolean flag;
    static int K,N,M,R,C;
    static String result;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        map = new char[n + 1][m + 1];
        K = k;
        N = n;
        M = m;
        R = r;
        C = c;
        hashMap = new HashMap<>();
        hashMap.put(0, "d");
        hashMap.put(1, "l");
        hashMap.put(2, "r");
        hashMap.put(3, "u");

        for (char[] ds : map) {
            Arrays.fill(ds, '.');
        }
        map[x][y] = 'S';
        map[r][c] = 'E';

        sb = new StringBuilder();
        flag = false;
        result = "impossible";
        if((k - Math.abs(R - x) + Math.abs(C - y)) % 2 == 1 || k < Math.abs(R - x) + Math.abs(C - y)) return "impossible";

        dfs(x, y, 0);
        answer = result;
        return answer;
    }

    public static void dfs(int x, int y, int cnt){
        if (flag) return;
        if (map[x][y] == 'E' && (K-cnt) % 2 == 1) return;
        if (map[x][y] == 'E' && cnt == K){
            result = sb.toString();
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (1 <= nextX && nextX <= N && 1 <= nextY && nextY <= M) {
                if (Math.abs(R - nextX) + Math.abs(C - nextY) <= (K - cnt)){
                    sb.append(hashMap.get(i));
                    dfs(nextX,nextY, cnt+1);
                    sb.delete(sb.length()-1, sb.length());
                }
            }
        }
    }
}
