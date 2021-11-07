class Solution {
    public int searchInsert(int[] nums, int target) {
        int leftMost = 0;
        int rightMost = nums.length - 1;
        int middle = (leftMost + rightMost) / 2;
        
        while (leftMost <= rightMost) {
            middle = (leftMost + rightMost) / 2;
            
            if (nums[middle] == target) {
                break;
            } 
            
            if (target < nums[middle]) {
                rightMost = middle - 1;
            } else {
                leftMost = middle + 1;
            }
            
        }

        if (nums[middle] == target) {
            return middle;
        } else {
            if (nums[middle] > target) {
                return (middle > 0) ? middle : 0;
            } else {
                return (middle < nums.length) ? middle + 1 : nums.length;
            }
        }
        
        
    }
}
