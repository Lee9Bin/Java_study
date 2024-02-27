package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10451 {
	
	static boolean[] visited;
	static int total;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			nums = new int[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <n+1; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n+1];
			
			total = 0;
			for (int i = 1; i < n+1; i++ ) {
//				if (!visited[i]) {
//					int index = i;
//					total ++ ;
//					while(true) {
//						if (visited[i]) break;
//						visited[nums[index]] = true;
//						index = nums[index];
//					}
//				}
				if (!visited[i]) {
					total++;
					dfs(nums[i], i);
				}
			}
			System.out.println(total);
		}
	}
	public static void dfs(int start, int end) {

		
		if (!visited[nums[start]]) {
			visited[nums[start]] = true;
			dfs(nums[start], end);			
		}
	}
}
