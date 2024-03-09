package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numList);
        // int i1 = Arrays.binarySearch(numList, 10);
        // System.out.println(i1);
        StringBuilder sb = new StringBuilder();
        for(int i : numList){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}
