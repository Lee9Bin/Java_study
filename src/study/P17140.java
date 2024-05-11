import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P17140 {

	static int[][] map;
	static int row;
	static int cal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[100][100];
		row = 3;
		cal = 3;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		r = r - 1;
		c = c - 1;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 끝

		int result = 0;
		while (true) {
			//문제 조건 찾으면
			if (map[r][c] == k) {
				break;
			}
			//100초가 지났음에도 못찾으면
			if (result == 101) {
				result = -1;
				break;
			}
			
			if (row >= cal)
				makeRowMatrix();
			else {
				makeCalMatrix();
			}
			result++;
		}
		System.out.println(result);
	}

	public static void makeRowMatrix() {

		int nowRow = row;
		int nowCal = cal;
		for (int i = 0; i < nowRow; i++) {
			// 숫자가 몇개인지 담을 hashmap 만들기
			HashMap<Integer, Integer> nums = new HashMap<>();
			for (int j = 0; j < nowCal; j++) {
				if (map[i][j] == 0)
					continue;
				if (nums.containsKey(map[i][j])) {
					nums.put(map[i][j], nums.get(map[i][j]) + 1);
				} else if (!nums.containsKey(map[i][j])) {
					nums.put(map[i][j], 1);
				}
				//0으로 초기화
				map[i][j] = 0;
			}

			//hashmap을 활용해 정렬하고 ArrayList로 뽑아내는 메서드
			ArrayList<int[]> temp = getArrayList(nums);
			//int[] { 숫자, 등장 횟수 }
			
			int index = 0;
			//temp 사이즈 만큼 해당 맵에 넣어주기
			for (int j = 0; j < temp.size(); j++) {
				if (index == 100)
					break;
				map[i][index++] = temp.get(j)[0];
				map[i][index++] = temp.get(j)[1];
			}
			
			//한 행의 최대 길이 업데이트
			cal = Math.max(cal, index);
		}

	}

	public static void makeCalMatrix() {

		int nowRow = row;
		int nowCal = cal;

		for (int i = 0; i < nowCal; i++) {
			HashMap<Integer, Integer> nums = new HashMap<>();
			for (int j = 0; j < nowRow; j++) {
				if (map[j][i] == 0)
					continue;
				if (nums.containsKey(map[j][i])) {
					nums.put(map[j][i], nums.get(map[j][i]) + 1);
				} else if (!nums.containsKey(map[j][i])) {
					nums.put(map[j][i], 1);
				}
				map[j][i] = 0;
			}


			ArrayList<int[]> temp = getArrayList(nums);

			int index = 0;
			for (int j = 0; j < temp.size(); j++) {
				if (index == 100)
					break;
				map[index++][i] = temp.get(j)[0];
				map[index++][i] = temp.get(j)[1];
			}
			//한 열의 최대 길이 업데이트
			row = Math.max(row, index);
		}

	}

	public static void showMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cal; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<int[]> getArrayList(HashMap<Integer, Integer> nums) {
		ArrayList<int[]> temp = new ArrayList<>();
		for (int num : nums.keySet()) {
			temp.add(new int[] { num, nums.get(num) });
		}
		temp.sort((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
		return temp;
	}
}
