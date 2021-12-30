class Solution {
    public int removeDuplicates(int[] nums) {
        // base case => given array is empty
        if (nums.length == 0) {
            return 0;
        }
        
        // declare variables used to modify/eliminate duplicates in-place
        int index = 1;
        int prev_val = nums[0];
        int k = 1;
        
        // main loop => 1 traversal O(n)
        while (index < nums.length) {
            // continue traversing till a new element appears
            if (nums[index] == prev_val) {
                index++;
            } 
            // update the array with the next new unique element
            else {
                prev_val = nums[index];
                nums[k] = nums[index];
                k++;
                index++;
            }
        }
        
        // return the number of unique elements in the array
        return k;
    }
}
