package solved.ac.class1;

import java.util.Scanner;

public class p2562 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] numlist = new int[9];

        for(int i = 0; i<9; i++){
            int n = in.nextInt();
            numlist[i] = n;
        }
        int max = 0;
        int maxwhere = 0;

        for (int i = 0; i<9;i++){
            if (numlist[i]>max){
                max = numlist[i];
                maxwhere = i;
            }
        }
        System.out.println(max);
        System.out.println(maxwhere+1);
    }
}
