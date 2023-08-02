package programmers.level1.기사단원의_무기;

public class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] attack = new int[number];
        for (int i = 1; i<number+1; i++){
            int cnt = 0;
            for (int j = 1; j<=(int)Math.sqrt(i); j++){
                if (i%j== 0 && Math.sqrt(i) == j){
                    cnt +=1;
                }
                else if(i%j== 0){
                    cnt +=2;
                }
            }
            if (i == 1){
                cnt = 1;
            }
            attack[i-1] = cnt;
        }

        for (int i = 0; i< number; i++){
            if (attack[i] <= limit){
                answer+= attack[i];
            }
            else{
                answer+= power;
            }
        }
        return answer;
    }
}