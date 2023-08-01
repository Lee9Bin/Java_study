package programmers.level1.덧칠하기;

public class Solution {
    public int solution(int n, int m, int[] section) {
        int[] block = new int[n];
        int answer = 0;
        for (int i = 0; i<section.length; i++){
            block[section[i]-1] = 1;
        }
        for (int i =0; i<block.length; i++){
            if(block[i] != 0){
                for (int j = i; j<i+m; j++){
                    if(j<block.length){
                        block[j] = 0;
                    }
                }
                answer +=1;
            }
        }
        return answer;
    }
}