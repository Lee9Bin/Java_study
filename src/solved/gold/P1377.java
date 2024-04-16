import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] origin = new int[n][];

		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			origin[i] = new int[] {num, i};
		}
		
		Arrays.sort(origin, (int[] o1, int[] o2) -> {
			return o1[0] - o2[0];
		});
		
	
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			if ((origin[i][1] - i) > result) {
				result = (origin[i][1] - i);
			}
		}
		System.out.println(result+1);
		
		
	}
}
