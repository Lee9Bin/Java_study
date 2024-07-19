package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();

        set.add(0);
        set.add(N);

        for (int i = 0; i < M; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> list = new ArrayList<>(set);

        Collections.sort(list);
        ArrayList<Integer> sub = new ArrayList<>();

        for (int i = 0; i < list.size()-1; i++){
            if (i == 0 || i == list.size()-2){
                sub.add(list.get(i+1) - list.get(i));
            }
            else{
                int a = list.get(i+1) - list.get(i);
                if (a % 2 == 0) sub.add(a/2);
                else sub.add((a/2)+1);
            }
        }

        Collections.sort(sub);
        System.out.println(sub.get(sub.size()-1));



    }
}
