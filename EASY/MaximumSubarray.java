class Solution {
    public int maxSubArray(int[] nums) {
        
        int currSum = nums[0];
        int upToNow = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (currSum + nums[i] < nums[i]) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            
            if (upToNow < currSum) {
                upToNow = currSum;
            }
        }
        
        return upToNow;
        
    }
}
