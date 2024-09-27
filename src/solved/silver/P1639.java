package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1639 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();

		int result = 0;
		for (int i = 0; i < num.length(); i++){
			for(int j = i; j <= num.length(); j+=2){
				if ( (j-i) % 2 ==0 && j-i != 0){
					int front = 0;
					int back = 0;
					for(int k = i; k < i + (j - i)/2; k++){
						front += num.charAt(k) - '0';
					}

					for(int k = i + (j - i)/2; k < j; k++){
						back += num.charAt(k) - '0';
					}
					if (front == back) {
						result = Math.max(result, (j-i));
					}

				}
			}
		}
		System.out.println(result);
	}
}
