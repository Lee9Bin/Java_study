package solved.class2;

import java.util.Scanner;

public class p2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[][] apart = new int[a+1][b+1];

            for (int cmd = 0; cmd<a+1; cmd++){
                for (int ho = 1; ho<b+1; ho++){
                    if(ho == 1){
                        apart[cmd][ho] = 1;
                    }
                    if (cmd == 0){
                        apart[cmd][ho] = ho;
                    }
                    else if (cmd != 0) {
                        apart[cmd][ho] = apart[cmd][ho-1] + apart[cmd-1][ho];
                    }
                }
            }
            System.out.println(apart[a][b]);
        }
    }
}
