package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6600 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			StringTokenizer st = new StringTokenizer(line);

			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());
			double x3 = Double.parseDouble(st.nextToken());
			double y3 = Double.parseDouble(st.nextToken());

			double d = 2 * ((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
			if (d == 0)
				continue;

			double ux = (((x1 * x1 + y1 * y1) * (y2 - y3)) +
				((x2 * x2 + y2 * y2) * (y3 - y1)) +
				((x3 * x3 + y3 * y3) * (y1 - y2))) / d;

			double uy = (((x1 * x1 + y1 * y1) * (x3 - x2)) +
				((x2 * x2 + y2 * y2) * (x1 - x3)) +
				((x3 * x3 + y3 * y3) * (x2 - x1))) / d;

			double radius = Math.sqrt((x1 - ux) * (x1 - ux) + (y1 - uy) * (y1 - uy));
			double circumference = 2 * Math.PI * radius;

			System.out.printf("%.2f\n", circumference);
		}
	}
}
