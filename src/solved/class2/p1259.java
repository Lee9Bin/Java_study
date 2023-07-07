package solved.class2;

import java.util.Scanner;

public class p1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String ans = "yes";
            String str = sc.next();
            if (str.equals("0")){
                break;
            }

            for (int i = 0; i < (str.length())/2; i++){
                char start = str.charAt(i);
                char end = str.charAt((str.length()-1)-i);
                if (start != end){
                    ans = "no";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
