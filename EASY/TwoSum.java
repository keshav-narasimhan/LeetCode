/* 
 * EASY 2/20/2021
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] targ_arr = new int[2];
        
        outerloop:
        for (int a = 0; a < nums.length; a++)
        {
            targ_arr[0] = a;
            for (int b = a + 1; b < nums.length; b++)
            {
                if (nums[a] + nums[b] == target)
                {
                    targ_arr[1] = b;
                    break outerloop;
                }
            }
        }   
        return targ_arr;
    }
}
