import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P25418 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> heap = new PriorityQueue<>(
				(int[] o1, int[] o2) -> {
					return o1[0] - o2[0];
				}
				);
		
		heap.add(new int[] {0,A});
		
		boolean[] visited = new boolean[1000001];
		visited[A] = true;
		
		while(!heap.isEmpty()) {
			int[] now = heap.poll();
			int cnt = now[0];
			int num = now[1];
			if (num == K) {
				System.out.println(cnt);
				break;
			}
			
			int[] next1 = new int[] {cnt+1, num + 1};
			if(num+1 < 1000001 && !visited[num+1]) {
				visited[num+1] = true;
				heap.add(next1);				
			}
			int[] next2 = new int[] {cnt+1, num * 2};
			if(num*2 < 1000001 && !visited[num*2] ) {
				visited[num*2] = true;
				heap.add(next2);				
			}
		}
	}
}
