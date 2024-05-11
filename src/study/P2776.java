import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class P2776 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int testNum = 1; testNum <= tests; testNum++) {
			int n1 = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n1; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (!map.containsKey(num)) map.put(num, 1);
				else {
					map.put(num, map.get(num)+1);
				}
			}
			int n2 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n2; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(!map.containsKey(num)) sb.append(0).append("\n");
				else{
					sb.append(1).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
