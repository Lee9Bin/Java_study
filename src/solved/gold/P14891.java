package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14891 {

	static ArrayList<ArrayList<Integer>> tobni;
	static int[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		tobni = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			char[] ch = br.readLine().toCharArray();
			tobni.add(new ArrayList<>());
			for (int j = 0; j < 8; j++) {
				tobni.get(i).add(ch[j] - '0');
			}
		}

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			flag = new int[4];
			flag[target - 1] = dir;
			possible(dir, target - 1);
			for (int k = 0; k < 4; k++) {
				if (flag[k] != 0)
					rotation(flag[k], k);
			}
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			ArrayList<Integer> target = tobni.get(i);
			if (target.get(0) == 1)
				result += (int) Math.pow(2, i);
		}
		System.out.println(result);

	}

	public static void possible(int dir, int target) {
		// 왼쪽에 위치한 톱니
		for (int i = target; 0 < i; i--) {
			ArrayList<Integer> left = tobni.get(i - 1);
			ArrayList<Integer> targetTobni = tobni.get(i);
			if (left.get(2) != targetTobni.get(6)) {
				if (flag[i] == 1) {
					flag[i - 1] = -1;
				} else {
					flag[i - 1] = 1;
				}

			} else {
				break;
			}
		}

		// 오른쪽에 위치한 톱니
		for (int i = target; i < 3; i++) {
			ArrayList<Integer> targetTobni = tobni.get(i);
			ArrayList<Integer> right = tobni.get(i + 1);
			if (right.get(6) != targetTobni.get(2)) {
				if (flag[i] == 1) {
					flag[i + 1] = -1;
				} else {
					flag[i + 1] = 1;
				}
			} else {
				break;
			}
		}
	}

	public static void rotation(int dir, int target) {
		ArrayList<Integer> targetList = tobni.get(target);
		int size = targetList.size();

		if (dir == 1) {
			int lastNum = targetList.remove(size - 1);
			targetList.add(0, lastNum);
		}
		if (dir == -1) {
			int firstNum = targetList.remove(0);
			targetList.add(firstNum);
		}
		// System.out.println(targetList);
	}

}
