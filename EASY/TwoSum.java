/* 
 * EASY 7/8/2020
 */

import java.util.HashMap;

public class TwoSum 
{
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> vals = new HashMap<>();
        int [] indices = new int[2];
        for (int index = 0; index < nums.length; index++)
        {
            int complement = target - nums[index];
            if (vals.containsKey(complement) && index != vals.get(complement))
            {
                indices[0] = index;
                indices[1] = vals.get(complement);
            }
            vals.put(nums[index], index);
        }
        return indices;
    }
}
