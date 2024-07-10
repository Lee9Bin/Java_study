package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2668 {

    static int N;
    static int[] nums;
    static boolean[] visited;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N+1; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        result = new ArrayList<>();
        for (int i = 1; i < N+1; i++){
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start, int target){
        if (nums[start] == target) result.add(start);

        if (!visited[nums[start]]){
            visited[nums[start]] = true;
            dfs(nums[start], target);
            visited[nums[start]] = false;
        }
    }
}
