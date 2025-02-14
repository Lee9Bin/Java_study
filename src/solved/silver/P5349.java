package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P5349 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<String> phoneNumbers = new HashSet<>();
		HashMap<String, Integer> check = new HashMap<>();

		while (true) {
			String phoneNumber = br.readLine();
			if (phoneNumber.equals("000-00-0000"))
				break;

			int count = check.getOrDefault(phoneNumber, 0);

			if (count == 0)
				check.put(phoneNumber, 1);
			else {
				phoneNumbers.add(phoneNumber);
			}
		}
		List<String> result = phoneNumbers.stream().sorted().collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		for (String s : result) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
