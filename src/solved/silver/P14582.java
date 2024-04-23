import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14582 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] first = new int[9];
		int[] second = new int[9];
		StringTokenizer stFirst = new StringTokenizer(br.readLine());
		StringTokenizer stSecond = new StringTokenizer(br.readLine());
		for (int i = 0; i < 9; i++) {
			first[i] = Integer.parseInt(stFirst.nextToken());
			second[i] = Integer.parseInt(stSecond.nextToken());
		}
		
		int ulim = 0;
		int start = 0;
		boolean win = false;
		boolean result = false;
		for (int i = 0; i < 9; i++) {
			ulim += first[i];
			if (ulim > start) win = true;
			start += second[i];
			if (win && start > ulim) {
				result = true;
			}
		}
		if (result) System.out.println("Yes");
		else System.out.println("No");
	}
}
