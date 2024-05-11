import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11497 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tests = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testNum = 1; testNum <= tests; testNum++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();
			
			for (int i = 0; i < n-1; i++) {
				if (i % 2 != 0) left.add(nums[i]);
				if (i % 2 == 0) right.add(nums[i]);
			}
			left.add(nums[n-1]);
			right.add(nums[n-1]);
			
			int result = 0;
			for (int i = 0; i < left.size()-1; i++) {
				result = Integer.max(Math.abs(left.get(i+1)-left.get(i)), result);
			}
			for (int i = 0; i < right.size()-1; i++) {
				result = Integer.max(Math.abs(right.get(i+1)-right.get(i)), result);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
