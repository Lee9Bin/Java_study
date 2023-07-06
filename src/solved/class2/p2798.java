package solved.class2;
import java.util.Scanner;

public class p2798 {
    static int cnt = 0;
    static int sum = 0;
    static int result = 0;
    public static void dfs(int[] numlist,int start,int m){
        if (cnt == 3){
            if (sum < m){
                result = Math.max(sum,result);
            }
            else if(sum == m){
                result = sum;
            }
            return;
        }
        for (int i = start; i<numlist.length; i++){
            sum += numlist[i];
            cnt +=1;
            dfs(numlist,i+1,m);
            sum -= numlist[i];
            cnt -= 1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] numlist = new int[n];
        for (int i = 0 ; i < n; i++){
            numlist[i] = sc.nextInt();
        }
        dfs(numlist,0,m);

        System.out.println(result);

    }
}
