package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int screen = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int start = 1;

        int j = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < j; i++){
            int num = Integer.parseInt(br.readLine());
            if (start <= num && num <= end) continue;
            int dir = num - start;

            if (dir > 0){ //오른쪽에 있다.
                start += num-end;
                result += (num - end);
                end += num-end;
            }
            else{ //왼쪽에 있다.
                start += dir;
                end += dir;
                result += Math.abs(dir);
            }

            // System.out.println(start +" " + end);
            // System.out.println(result);
        }
        System.out.println(result);

    }
}
