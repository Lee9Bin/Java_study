package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P6216 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		HashMap<Character, Integer> dic = new HashMap<>();
		dic.put('0',0);
		dic.put('1',0);
		dic.put('2',0);
		dic.put('3',0);
		dic.put('4',0);
		dic.put('5',0);
		dic.put('6',0);
		dic.put('7',0);
		dic.put('8',0);
		dic.put('9',0);

		for (int i = A; i <= B; i++){
			String num = String.valueOf(i);
			for (int j = 0; j < num.length(); j++){
				dic.put(num.charAt(j), dic.get(num.charAt(j))+1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : dic.keySet()) {
			sb.append(dic.get(c)).append(" ");
		}
		System.out.println(sb);
	}
}
