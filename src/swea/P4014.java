package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4014 {
    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int testNum = 1; testNum <= testCase; testNum++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 입력 끝

            int total = 0;
            for (int i = 0; i < N; i++) {
                if (rowCheck(i)) total++;
                if (calCheck(i)) total++;
            }

            sb.append("#").append(testNum).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean rowCheck(int i) {
        // 현재 계단 높이
        int now = map[i][0];
        int ct = 1;

        for (int j = 1; j < N; j++) {
            // 다음 계단 높이
            int next = map[i][j];

            if (Math.abs(now - next) > 1) return false; // 계단높이 차가 2 이상이다.

            else if (now == next) ct++; // 같을 경우 건설 가능한 길 +

            else if (now - next == -1) { // 오르막 - 이전에 지나온 길 보기
                if (ct < X) return false;// 건설 가능한 길이 적다
                now = map[i][j]; // 현재 계단 높이 바꿔주기
                ct = 1; // 오르막일때는 지나온 길에 설치했기 때문에 바꾼 위치에는 건설가능
            } else if (now - next == 1) { // 내리막 - 앞에 길 보기
                if (N - j < X) return false; // 앞에 길 수가 적다.
                int downCount = 0;
                int downNum = map[i][j];

                for (int k = j; k < j + X; k++) {
                    if (downNum == map[i][k]) downCount++;
                }

                if (downCount < X) return false;

                j = j + X - 1;  // 건설된 마지막 위치 부터
                now = map[i][j]; // 현재 계단 높이 바꿔주기
                ct = 0; // 내리막일때는 바꾼 위치에는 건설 불가능
            }
        }
        return true;
    }

    public static boolean calCheck(int i) {
        int now = map[0][i];
        int ct = 1;

        for (int j = 1; j < N; j++) {
            // 다음 계단 높이
            int next = map[j][i];

            if (Math.abs(now - next) > 1) return false; // 계단높이 차가 2 이상이다.

            else if (now == next) ct++; // 같을 경우 건설 가능한 길 +

            else if (now - next == -1) { // 오르막 - 이전에 지나온 길 보기
                if (ct < X) return false;// 건설 가능한 길이 적다
                now = map[j][i]; // 현재 계단 높이 바꿔주기
                ct = 1; // 오르막일때는 지나온 길에 설치했기 때문에 다음 위치에는 건설가능
            } else if (now - next == 1) { // 내리막 - 앞에 길 보기
                if (N - j < X) return false; // 앞에 길 수가 적다.
                int downCount = 0;
                int downNum = map[j][i];

                for (int k = j; k < j + X; k++) {
                    if (downNum == map[k][i]) downCount++;
                }

                if (downCount < X) return false;

                j = j + X - 1;  // 건설된 마지막 위치 부터
                now = map[j][i]; // 현재 계단 높이 바꿔주기
                ct = 0; // 내리막일때는 바꾼 위치에는 건설 불가능
            }
        }
        return true;
    }
}
