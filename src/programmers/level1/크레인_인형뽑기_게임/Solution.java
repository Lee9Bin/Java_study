package programmers.level1.크레인_인형뽑기_게임;

import java.util.*;
public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>()    ;
        for (int i = 0; i < moves.length; i++){
            for (int x= 0; x< board.length; x++){
                if (board[x][moves[i]-1] !=0){
                    System.out.println(board[x][moves[i]-1]);
                    if (stack.isEmpty()){
                        stack.push(board[x][moves[i]-1]);
                    }
                    else{
                        if(stack.peek() == board[x][moves[i]-1]){
                            answer+=2;
                            stack.pop();
                        }
                        else{
                            stack.push(board[x][moves[i]-1]);
                        }
                    }
                    board[x][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}