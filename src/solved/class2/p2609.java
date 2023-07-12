package solved.class2;
import java.util.Scanner;

public class p2609 {
    static int a,b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        int result1 = 1;
        int result2 = 1;
        for (int i = 1; i < (a>b?b:a); i ++ ){
            if (a%i == 0 && b%i == 0){
                result1 = i;
            }
        }
        for (int i = (a>b?b:a); i <= a*b; i++ ){
            if (i%a == 0 && i%b == 0){
                result2 = i;
                break;
            }
        }
        System.out.println(result1);
        System.out.println(result2);
    }
}
