package programmers.level1.직사각형_별찍기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i<b; i++){
            String ans = "";
            for (int j = 0; j<a; j++){
                ans += "*";
            }
            System.out.println(ans);
        }
    }
}