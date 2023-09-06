package programmers.level1.바탕화면_정리;

public class Solution {
    public int[] solution(String[] wallpaper) {
        String[][] wall = new String[wallpaper.length][wallpaper[0].length()];
        int[] answer = {9999,9999,-1,-1};

        for (int i = 0; i<wallpaper.length; i++){
            wall[i] = wallpaper[i].split("");
        }
        //위에 있는거 찾기
        for(int i = 0; i < wall.length; i++){
            for (int j = 0; j < wall[0].length; j++){
                if (wall[i][j].equals("#") && answer[0] > i){
                    answer[0] = i;
                }
                if (wall[i][j].equals("#") && answer[1] > j){
                    answer[1] = j;
                }
                if (wall[i][j].equals("#") && answer[2] < i+1){
                    answer[2] = i+1;
                }
                if (wall[i][j].equals("#") && answer[3] < j+1){
                    answer[3] = j+1;
                }
            }
        }
        return answer;
    }
}