package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {

    static int[] visited;
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        visited = new int[15];
        madeQueens(0);
        System.out.println(result);
    }

    public static boolean isPossible(int idx){

        for (int i = 0; i < idx; i++){
            if (visited[i] == visited[idx] || idx - i == Math.abs(visited[idx] - visited[i])){
                return false;
            }
        }
        return true;
    }

    public static void madeQueens(int idx){
        if (idx == n){
            result ++;
            return;
        }

        for (int i = 0; i < n; i++){
            visited[idx] = i;
            if(isPossible(idx)){
                madeQueens(idx+1);
            }

        }
    }
}

