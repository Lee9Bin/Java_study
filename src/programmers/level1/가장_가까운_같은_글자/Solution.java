package programmers.level1.가장_가까운_같은_글자;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] visited = new int[124];
        for (int i = 1; i<s.length()+1; i++){
            if (visited[(int)s.charAt(i-1)] == 0){
                visited[(int)s.charAt(i-1)] = i;
                answer[i-1] = -1;
            }
            else if(visited[(int)s.charAt(i-1)] != 0){
                answer[i-1] = i - visited[(int)s.charAt(i-1)];
                visited[(int)s.charAt(i-1)] = i;
            }
        }
        return answer;
    }
}