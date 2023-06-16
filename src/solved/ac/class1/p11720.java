package solved.ac.class1;

import java.util.Scanner;

public class p11720 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = in.next().split("");
        int sum = 0;
        for (int i = 0; i<n; i++){
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
    }
}
