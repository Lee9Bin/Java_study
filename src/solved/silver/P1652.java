package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for (int i = 0; i < n ; i++){
            map[i] = br.readLine().toCharArray();
        }

        int row = 0;
        for(int i = 0 ; i < n; i++){
            int possible = 0;
            for (int j = 0; j < n; j++){
                if (map[i][j] == '.') possible ++;
                else{
                    if (possible >= 2) row ++;
                    possible = 0;
                }
            }
            if (possible >= 2) row ++;
        }

        int cal = 0;
        for(int i = 0 ; i < n; i++){
            int possible = 0;
            for (int j = 0; j < n; j++){
                if (map[j][i] == '.') possible ++;
                else{
                    if (possible >= 2) cal ++;
                    possible = 0;
                }
            }
            if (possible >= 2) cal ++;
        }
        System.out.println(row + " " + cal);
    }
}
