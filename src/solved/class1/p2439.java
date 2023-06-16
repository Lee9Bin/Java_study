package solved.class1;

import java.util.Scanner;

public class p2439 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i<n; i++){
            for (int j = n; j>0; j--){
                if(j>i+1){
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
