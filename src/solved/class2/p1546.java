package solved.class2;

import java.util.Scanner;

public class p1546 {
    static int N;
    static double sum;
    static int[] numlist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numlist = new int[N];

        for (int i = 0; i < N; i++){
            numlist[i] = sc.nextInt();
        }

        double max = numlist[0];
        for (int i = 0; i < N; i++){
            if(max < numlist[i]){
                max = numlist[i];
            }
        }
        for (int i = 0; i < N; i++){
            sum += numlist[i]/max*100;
        }

        System.out.println(sum/N);
    }
}
