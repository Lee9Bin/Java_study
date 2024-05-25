package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P19949 {

    static int[] answer;
    static int[] make;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[10];
        make = new int[10];

        for (int i = 0; i < 10; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        setMake(0);
        System.out.println(result);
    }

    static void setMake(int index){
        if (index == 10){
            int cnt = 0;
            for (int i = 0; i < 10; i++){
                if (make[i] == answer[i]) cnt ++;
            }
            if (cnt >=5) result++;
            return;
        }

        for (int i = 1; i <=5; i++ ){
            if(index >=2 && make[index-2] == i & make[index-1] == i) continue;
            make[index] = i;
            setMake(index+1);
        }
    }
}
