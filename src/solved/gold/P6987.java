package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6987 {
    static int[][] game;
    static int[][] arr;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 4; k++) {
            result = false;
            game = new int[6][3];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 3; y++) {
                    game[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            arr = new int[15][2];
            int size = 0;
            for (int i = 0; i < 6; i++) {
                for(int j = i+1; j < 6; j++) {
                    arr[size][0] = i;
                    arr[size][1] = j;
                    size ++;
                }
            }

            back(0);
            if (result) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    public static void back(int start) {
        if (start == 15) {
            for(int i = 0; i < 6; i++) {
                for (int j = 0; j<3; j++) {
                    if (game[i][j] != 0)
                        return;
                }
            }
            result = true;
            return;
        }

        //승
        if (game[arr[start][0]][0] > 0 && game[arr[start][1]][2] > 0) {
            game[arr[start][0]][0] -= 1;
            game[arr[start][1]][2] -= 1;
            back(start + 1);
            game[arr[start][0]][0] += 1;
            game[arr[start][1]][2] += 1;
        }
        //무
        if (game[arr[start][0]][1] > 0 && game[arr[start][1]][1] > 0) {
            game[arr[start][0]][1] -= 1;
            game[arr[start][1]][1] -= 1;
            back(start + 1);
            game[arr[start][0]][1] += 1;
            game[arr[start][1]][1] += 1;
        }
        //패
        if (game[arr[start][0]][2] > 0 && game[arr[start][1]][0] > 0) {
            game[arr[start][0]][2] -= 1;
            game[arr[start][1]][0] -= 1;
            back(start + 1);
            game[arr[start][0]][2] += 1;
            game[arr[start][1]][0] += 1;
        }
    }
}
