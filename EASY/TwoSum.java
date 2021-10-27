/* 
 * EASY 2/20/2021
 */

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int [] targ_arr = new int[2];
        
//         outerloop:
//         for (int a = 0; a < nums.length; a++)
//         {
//             targ_arr[0] = a;
//             for (int b = a + 1; b < nums.length; b++)
//             {
//                 if (nums[a] + nums[b] == target)
//                 {
//                     targ_arr[1] = b;
//                     break outerloop;
//                 }
//             }
//         }   
//         return targ_arr;
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> n = new HashMap<>();
        int [] index = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            if (n.containsKey(nums[i])) {
                if (n.get(nums[i]) == -1) {
                    index[0] = i;
                    index[1] = n.get(target - nums[i]);
                } else if (n.get(nums[i]) == n.get(target - nums[i])) {
                    index[0] = i;
                    index[1] = n.get(nums[i]);
                }
            } else {
                n.put(nums[i], i);
                if (target - nums[i] != nums[i]) {
                    n.put(target-nums[i], -1);
                }
                
            }
        }
        
        return index;
    }
}
