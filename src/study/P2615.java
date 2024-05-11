package study;
import java.util.Scanner;

public class P2615 {
    private static String winner = "0";
    private static int[] result = new int[2];

    public static void main(String[] args) throws Exception {
        String[][] board = new String[19][19];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i<19; i++) {
            board[i] = sc.nextLine().split(" ");
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (!(board[i][j].equals("0"))) {
                    check(i,j,board[i][j],board);
                    if (!(winner.equals("0"))) {
                        break;
                    }
                }
            }
            if (!(winner.equals("0"))) {
                break;
            }
        }

        if (winner.equals("0")) {
            System.out.println("0");
        }
        else {
            System.out.println(winner);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static void check(int x, int y, String stone, String[][] board) {
        int[] dx = {-1, 0, 1, 1};
        int[] dy = {1, 1, 1, 0};
        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            while(true) {
                if ( nextX < 0 || nextY < 0 || nextX >= 19 || nextY >= 19) {
                    break;
                }
                if (board[nextX][nextY].equals(stone)) {
                    cnt +=1 ;
                }
                else {
                    break;
                }
                nextX = nextX + dx[i];
                nextY = nextY + dy[i];
            }

            int rcnt = 0;
            nextX = x - dx[i];
            nextY = y - dy[i];
            while(true) {
                if ( nextX < 0 || nextY < 0 || nextX >= 19 || nextY >= 19) {
                    break;
                }
                if (board[nextX][nextY].equals(stone)) {
                    rcnt += 1 ;
                }
                else {
                    break;
                }
                nextX = nextX - dx[i];
                nextY = nextY - dy[i];
            }
            if (cnt == 5 && rcnt == 0) {

                winner = stone;
                result[0] = x+1;
                result[1] = y+1;
                break ;
            }
        }
    }
}

