import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11508 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);
		
		for (int i = 0; i < n; i++) {
			heap.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		while(!heap.isEmpty()) {
			if (heap.size() >=3 ) {
				for (int i = 0; i < 2; i++) result += heap.poll();
				heap.poll();
			}
			else {
				for (int i =0; i < heap.size(); i++) {
					result += heap.poll();
				}
			}
		}
		System.out.println(result);
		
	}
}
// 10 9 6 4 4 3 2
// 10 3 2 -> 5
// 9 4 4 -> 8
// 6 -> 6