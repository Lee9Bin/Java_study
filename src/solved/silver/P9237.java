import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P9237 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] trees = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		for (int i = 0 ; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);

		for (int i = n-1 ; i >= 0; i--) {
			result = Math.max(result, trees[i] + n-i + 1);
		}
		System.out.println(result);
	}
}
