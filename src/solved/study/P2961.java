package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2961 {
    static int result = Integer.MAX_VALUE;
    static int n;
    static int[][] food;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        food = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
        back(1,0,0);
        System.out.println(result);

    }


    public static void back(int sour,int sweet,int start) {

        for (int i = start; i< n; i++) {
            result = Math.min((int)Math.abs(sour*food[i][0]-(sweet+food[i][1])), result);
            back(sour*food[i][0], sweet+food[i][1], i+1);
        }
    }
}
