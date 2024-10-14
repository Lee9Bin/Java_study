package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P21608 {

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, 1, 0, -1};

	static int N;
	static int[][] map, students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		students = new int[N * N + 1][N*N+1];
		int result = 0;

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				students[now][Integer.parseInt(st.nextToken())] = 1;
			}
			PriorityQueue<int[]> candidateSheets = makeCandidateSheets(now);
			int[] sheet = candidateSheets.poll();
			map[sheet[0]][sheet[1]] = now;
		}

		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int nextX = i + dx[k];
					int nextY = j + dy[k];
					if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
						if(students[map[i][j]][map[nextX][nextY]] == 1) count++;
					}
				}
				result += Math.pow(10, count-1);

			}
		}
		System.out.println(result);
	}

	//1. 비어있는 칸 중에서 학생이 인접한 칸에 가장 많은 칸으로 정한다.
	//2. 1을 만족하는 칸이 여러개이면, 인접한 칸중에서 비어있는 칸이 가장 많은 칸으로 정한다.
	//3. 2를 만족하는 칸이 여러개라면 행이 가장 작은, 또 같으면 열이 가장 적은
	//int[] {x, y, likeCount, emptyCount}
	public static PriorityQueue<int[]> makeCandidateSheets(int student) {

		PriorityQueue<int[]> candidateSheets = new PriorityQueue<>(
			(int[] o1, int[] o2) -> o1[2] != o2[2] ? o2[2] - o1[2] :
				o1[3] != o2[3] ? o2[3] - o1[3] : o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					int likeCount = 0;
					int emptyCount = 0;
					for (int k = 0; k < 4; k++) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
						if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
							if (students[student][map[nextX][nextY]] == 1)
								likeCount++;
							else if (map[nextX][nextY] == 0)
								emptyCount++;
						}
					}
					candidateSheets.add(new int[] {i, j, likeCount, emptyCount});
				}
			}
		}
		return candidateSheets;
	}
}
