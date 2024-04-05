import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2535 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] students = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			students[i] =new int[] {a,b,c};
		}
		
		
		Arrays.sort(students, (int[] o1, int[] o2) -> {
			return o2[2] - o1[2];
		} );
		int[] count = new int[101];
		int[][] result = new int[3][2];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (count[students[i][0]] < 2) {
				count[students[i][0]] ++;
				result[index++] = new int[] {students[i][0], students[i][1] };
			}
			if (index == 3) break;
		}
		for (int[] is : result) {
			System.out.println(is[0] + " " + is[1]);
		}
	}
}
