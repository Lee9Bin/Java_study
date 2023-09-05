package programmers.level1.햄버거_만들기;
import java.util.*;
public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i<ingredient.length; i++){
            result.push(ingredient[i]);
            if (result.size()>=4 && result.get(result.size()-1)==1){
                if(result.get(result.size()-2) == 3 && result.get(result.size()-3) == 2 &&result.get(result.size()-4) ==1){
                    answer +=1;
                    for (int k = 0; k<4; k++){
                        result.pop();
                    }
                }
            }
        }
        return answer;
    }
}
