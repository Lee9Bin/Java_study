package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String target = br.readLine();
		int result = 0;
		int sLength = S.length();
		int targetLength = target.length();
		for (int i = 0; i < targetLength-sLength; i++){
			char now = target.charAt(target.length()-1);
			if (now == 'B'){
				StringBuilder sb = new StringBuilder(target.substring(0, target.length()-1)).reverse();
				target = sb.toString();
			}
			else {
				target = target.substring(0, target.length()-1);
			}
		}
		if(target.equals(S)) result = 1;
		System.out.println(result);
	}
}
