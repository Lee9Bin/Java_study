package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N, X 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        //방문자수 저장
        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++){
            visits[i] = Integer.parseInt(st.nextToken());
        }

        //X일 만큼 방문자수 합해서 저장
        int result = 0;
        for (int i = 0; i < X; i++){
            result += visits[i];
        }

        int nowVisits = result;
        int days = 1;
        for (int i = X; i < N; i++){
            //새로운 날의 방문자수를 더한다.
            nowVisits += visits[i];
            //첫날의 방문자수를 뺀다.
            nowVisits -= visits[i-X];

            if (result < nowVisits){
                result = nowVisits;
                days = 1;
            }
            else if (result == nowVisits){
                days ++;
            }
        }
        if (result == 0) System.out.println("SAD");
        else{
            System.out.println(result);
            System.out.println(days);
        }
    }
}
