package solved.study.몸짱_트레이너_라이언의_고민;

import java.util.ArrayList;

public class Solution {
    static int[] times;
    static int N;

    public int solution(int n, int m, int[][] timetable) {
        int answer = 0;
        times = new int[1321];
        N = n;

        for (int i = 600; i < 1321; i++){
            for (int[] time : timetable) {
                int startTime = time[0];
                int endTime = time[1];
                if (startTime <= i && i <= endTime) times[i] ++;
            }
        }

        int maxCount = 0;
        for (int count : times) {
            maxCount = Math.max(maxCount, count);
        }
        //시간대에 몰리는 최대 인원 수 구하기 끝

        //1 이하면 바로 종료
        if (maxCount <= 1) return 0;

        //n *n 격자에서 최대 거리는 2 * (n-1) 대각선
        //따라서 거리를 -1 씩 줄여가면서 탐색
        for (int dis = 2 * (n-1); dis >= 1; dis--){
            //해당 거리 이상인 조합 찾기
            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    // 한 좌표씩 선택
                    ArrayList<int[]> select = new ArrayList<>();
                    boolean[][] visited = new boolean[N][N];
                    select.add(new int[] {i, j});
                    visited[i][j] = true;

                    //기준 좌표 기준으로 다른 좌표 탐색
                    for (int x = i; x < N; x++){
                        for (int y = 0; y < N; y++){
                            if (visited[x][y]) continue;

                            boolean flag = true;

                            //현재 선택된 거리에 부합 하지 않으면 선택하지 않기
                            for (int[] selected : select){
                                int nowDis = Math.abs(selected[0]-x) + Math.abs(selected[1] - y);
                                if (nowDis < dis) {
                                    flag = false;
                                    break;
                                }
                            }

                            //부합 하면 선택 후 추가
                            if(flag){
                                select.add(new int[] {x, y});
                                //해당 피크타임 인원수에 만족하면 답 도출
                                if (select.size() == maxCount){
                                    return dis;
                                }
                            }

                        }
                    }
                }
            }
        }

        return answer;
    }


}
