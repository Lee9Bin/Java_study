import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P13417 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tests = 1; tests <t+1; tests++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayDeque<Character> deque = new ArrayDeque<>();
			for (int i = 0; i < n ; i++) {
				char ch = st.nextToken().charAt(0);
				if (deque.isEmpty()) {
					deque.add(ch);
				}
				else {
					if (deque.peekFirst() >= ch) deque.addFirst(ch);
					else deque.addLast(ch);
				}
			}
			
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
