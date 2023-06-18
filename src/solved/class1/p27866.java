package solved.class1;

import java.util.Arrays;
import java.util.Scanner;

public class p27866 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = sc.nextInt();
        String[] arr = s.split("");
        System.out.println(arr[i-1]);
    }
}
