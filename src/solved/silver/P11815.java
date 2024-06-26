package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        long[] nums = new long[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0 ; i < count; i++){
            long sqrt = (long) Math.sqrt(nums[i]);
            if (nums[i] == sqrt * sqrt){
                System.out.print(1 + " ");
            }
            else{
                System.out.print(0 + " ");
            }
        }
    }
}
