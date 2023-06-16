package solved.ac.class1;

import java.util.Scanner;

public class p2739 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        for (int i =1; i<10; i++){
            System.out.printf("%d * %d = %d",a,i,a*i);
            System.out.println("");
        }
    }
}
