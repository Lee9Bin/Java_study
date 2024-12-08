package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10655 {

    static int n, result;
    static int[][] cordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cordinates = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cordinates[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int totalDist = 0;
        for (int i = 1; i < n; i++) {
            totalDist += Math.abs(cordinates[i - 1][0] - cordinates[i][0]) + Math.abs(cordinates[i - 1][1] - cordinates[i][1]);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int newDist = totalDist - (Math.abs(cordinates[i - 1][0] - cordinates[i][0]) + Math.abs(cordinates[i - 1][1] - cordinates[i][1]))
                    - (Math.abs(cordinates[i + 1][0] - cordinates[i][0]) + Math.abs(cordinates[i + 1][1] - cordinates[i][1]));
            result = Math.min(result, newDist + Math.abs(cordinates[i - 1][0] - cordinates[i + 1][0]) + Math.abs(cordinates[i - 1][1] - cordinates[i + 1][1]));
        }
        System.out.println(result);
    }
}
