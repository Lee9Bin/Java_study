package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] pascal = new int[31][31];

        for (int i = 1; i < 31; i++){
            for (int j = 1; j <31; j++){
                if (j == 1 || j == 30) pascal[i][j] = 1;
                else{
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }

        System.out.println(pascal[x][y]);

    }
}
