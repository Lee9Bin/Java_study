import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14469 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> heap = new PriorityQueue<>((int[] o1, int[] o2) -> {
			
			return o1[0] - o2[0];
		});
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			heap.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		int total = 0;
		int nowTime = 0;
		int waitTime = 0;
		while(!heap.isEmpty()) {
			int[] now = heap.poll();
			nowTime = now[0];
			waitTime = now[1];
			if (total < nowTime) {
				total = nowTime;
			}
			total += waitTime;
			
		}
		System.out.println(total);
	}
}
