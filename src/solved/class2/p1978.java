package solved.class2;
import java.util.*;
public class p1978 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        int cnt = 0;

        for (int num : arr){
            for (int i =2 ; i<=num;i++){
                if (i == num){
                    cnt +=1;
                }
                if (num % i ==0){
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
