package solved.class1;

import java.util.Scanner;

public class p2475 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i<5;i++){
            arr[i] = in.nextInt();
        }
        int sum = 0;

        for (int i =0; i<5;i++){
            sum += arr[i]*arr[i];
        }
        System.out.println(sum%10);
    }
}
