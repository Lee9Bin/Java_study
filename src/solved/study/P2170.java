import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2170 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> coordinates = new ArrayList<>();
		
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coordinates.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(coordinates,(int[] o1, int[] o2) -> {
			return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
		});
		
		int start = coordinates.get(0)[0];
		int end = coordinates.get(0)[1];
		
		int total = 0;
		for (int i = 1; i < n; i++) {
			int nextStart = coordinates.get(i)[0];
			int nextEnd = coordinates.get(i)[1];
			if (nextStart <= end) {
				if (end < nextEnd) end = nextEnd;
			}
			else {
				total += Math.abs(end-start);
				start = nextStart;
				end = nextEnd;
			}
		}
		
		total += Math.abs(end-start);
		System.out.println(total);
	}

}
