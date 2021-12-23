class Solution {
    public int rob(int[] nums) {
        // if there is only 1 house, rob it
        if (nums.length == 1) {
            return nums[0];
        }
        
        // dynamic programming table
        int[] Table = new int[nums.length];
        
        // base cases
        Table[0] = nums[0];
        Table[1] = Math.max(nums[0], nums[1]);
        
        // OPT(i) = max(OPT(i - 2) + nums(i), OPT(i - 1))
        for (int i = 2; i < nums.length; i++) {
            Table[i] = Math.max(Table[i - 2] + nums[i], Table[i - 1]);
        }
        
        // return the optimal value for n houses
        return Table[nums.length - 1];
    }
}
