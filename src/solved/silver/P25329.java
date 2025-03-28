package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class P25329 {

	static class Student {
		String name;
		int time;

		public Student(String name, int time) {
			this.name = name;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> info = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] times = st.nextToken().split(":");
			String name = st.nextToken();
			int total = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

			if (info.containsKey(name))
				info.put(name, info.get(name) + total);
			else
				info.put(name, total);
		}

		List<Student> result = new ArrayList<>();
		for (String s : info.keySet()) {
			int cost = 10;
			if (info.get(s) > 100) {
				cost += ((info.get(s) - 100) / 50) * 3;
				if ((info.get(s) - 100) % 50 != 0)
					cost += 3;
			}
			result.add(new Student(s, cost));
		}

		result.sort((Student s1, Student s2) -> {
			return s1.time != s2.time ? s2.time - s1.time : s1.name.compareTo(s2.name);
		});

		StringBuilder sb = new StringBuilder();
		for (Student student : result) {
			sb.append(student.name).append(" ").append(student.time).append("\n");
		}
		System.out.println(sb);
	}
}
