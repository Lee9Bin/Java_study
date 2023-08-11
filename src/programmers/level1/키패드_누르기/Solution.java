package programmers.level1.키패드_누르기;
public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = {3,0};
        int[] right ={3,2};
        String[][] phone = {{"1","2","3"}
                ,{"4","5","6"}
                ,{"7","8","9"}
                ,{"11","0","12"}};
        for (int i =0; i<numbers.length; i++){
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                if (numbers[i] == 1){
                    left[0] = 0;
                    left[1] = 0;
                }
                if (numbers[i] == 4){
                    left[0] = 1;
                    left[1] = 0;
                }
                if (numbers[i] == 7){
                    left[0] = 2;
                    left[1] = 0;

                }
                answer += "L";
            }
            else if(numbers[i] == 3 ||numbers[i] == 6 ||numbers[i] == 9){
                if (numbers[i] == 3){
                    right[0] = 0;
                    right[1] = 2;
                }
                if (numbers[i] == 6){
                    right[0] = 1;
                    right[1] = 2;
                }
                if (numbers[i] == 9){
                    right[0] = 2;
                    right[1] = 2;
                }
                answer += "R";
            }

            else{
                for (int x = 0; x<4; x++){
                    for (int y = 0; y<3 ;y++){
                        int a = Integer.parseInt(phone[x][y]);
                        if(numbers[i]==a){
                            if (Math.abs(left[0]-x)+Math.abs(left[1]-y) > Math.abs(right[0]-x)+Math.abs(right[1]-y)){
                                right[0] = x;
                                right[1] = y;
                                answer += "R";
                            }
                            else if (Math.abs(left[0]-x)+Math.abs(left[1]-y) < Math.abs(right[0]-x)+Math.abs(right[1]-y)){
                                left[0] = x;
                                left[1] = y;
                                answer += "L";
                            }
                            else if (Math.abs(left[0]-x)+Math.abs(left[1]-y) == Math.abs(right[0]-x)+Math.abs(right[1]-y)){
                                if (hand.equals("right"))
                                {
                                    right[0] = x;
                                    right[1] = y;
                                    answer += "R";}
                                if (hand.equals("left"))
                                {
                                    left[0] = x;
                                    left[1] = y;
                                    answer += "L";}
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println(left[0]);
            System.out.println(left[1]);
            System.out.println(right[0]);
            System.out.println(right[1]);

        }
        return answer;
    }
}
