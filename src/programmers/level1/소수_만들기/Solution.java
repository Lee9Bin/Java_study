package programmers.level1.소수_만들기;

public class Solution {
    static int cnt = 0;
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i<nums.length; i++){
            int sum = nums[i];
            for(int j = i+1; j<nums.length; j++){
                sum += nums[j];
                for(int k = j+1; k<nums.length; k++){
                    sum += nums[k];
                    for (int z = 2; z<=sum; z++){
                        if(z == sum){
                            answer +=1;
                        }
                        if (sum % z == 0){
                            break;
                        }
                    }
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
        }
        return answer;
    }
}