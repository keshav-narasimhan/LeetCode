class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sort the array => O(nlog(n)) time
        Arrays.sort(nums);
        
        // keep track of the closest sum to target
        int closestSum = nums[0] + nums[1] + nums[2];
        
        int leftPtr;
        int rightPtr;
        for (int i = 0; i < nums.length - 2; i++) {
            // get 2 additional ptrs
            leftPtr = i + 1;
            rightPtr = nums.length - 1;
            
            // find the closest sum using 2Sum + nums[i]
            while (leftPtr < rightPtr) {
                if (nums[leftPtr] + nums[rightPtr] + nums[i] == target) {
                    return target;
                } else if(nums[leftPtr] + nums[rightPtr] + nums[i] > target) {
                    closestSum = updateClosestSum(nums, i, leftPtr, rightPtr, target, closestSum);
                    rightPtr--;
                } else {
                    closestSum = updateClosestSum(nums, i, leftPtr, rightPtr, target, closestSum);
                    leftPtr++;
                }
            }
        }
        
        // return the closest sum => O(n^2) runtime complexity
        return closestSum;
    }
    
    // helper method to update closestSum variable in loop
    private int updateClosestSum(int[] nums, int ind1, int ind2, int ind3, int target, int closestSum) {
        
        if (Math.abs(target - (nums[ind2] + nums[ind3] + nums[ind1])) < Math.abs(target - closestSum)) {
            closestSum = nums[ind2] + nums[ind3] + nums[ind1];
        }
        
        return closestSum;
    }
}
