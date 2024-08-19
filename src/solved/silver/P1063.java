package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1063 {

	static final int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

	static int[][] map = new int[8][8];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();

		int kingY = king.charAt(0) - 65;
		int kingX = 8 - (king.charAt(1) - '0');
		map[kingX][kingY] = 1;

		String stone = st.nextToken();
		int stoneY = stone.charAt(0) - 65;
		int stoneX = 8 - (stone.charAt(1) - '0');
		map[stoneX][stoneY] = 2;

		int count = Integer.parseInt(st.nextToken());
		for (int i = 0; i < count; i++){
			String info = br.readLine();
			int k = dir(info);
			int kingNx = kingX + dx[k];
			int kingNy = kingY + dy[k];
			int stoneNx = stoneX + dx[k];
			int stoneNy = stoneY + dy[k];
			if (kingNx == stoneX && kingNy == stoneY){
				if (rangeCheck(stoneNx,stoneNy) && rangeCheck(kingNx, kingNy)){
					kingX = kingNx;
					kingY = kingNy;
					stoneX = stoneNx;
					stoneY = stoneNy;
				}
			}
			else {
				if (rangeCheck(kingNx,kingNy)){
					kingX = kingNx;
					kingY = kingNy;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append((char)(kingY + 65)).append(8-kingX).append("\n");
		sb.append((char)(stoneY + 65)).append(8-stoneX).append("\n");
		System.out.println(sb);
	}

	public static int dir(String info){
		int i = 0;
		if (info.equals("R")){
			i = 0;
		}
		if (info.equals("L")){
			i = 1;
		}
		if (info.equals("B")){
			i = 2;
		}
		if (info.equals("T")){
			i = 3;
		}
		if (info.equals("RT")){
			i = 4;
		}
		if (info.equals("LT")){
			i = 5;
		}
		if (info.equals("RB")){
			i = 6;
		}
		if (info.equals("LB")){
			i = 7;
		}
		return i;
	}

	public static boolean rangeCheck(int x, int y){
		if (x < 0 || y < 0 || x >= 8 || y >= 8) {
			return false;
		}
		return true;
	}
}
