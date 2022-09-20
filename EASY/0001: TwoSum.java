class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        // Brute Force
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                if (first + second == target) {
                    int [] result = { i, j };
                    return result;
                }
            }
        }
        
        int [] result = new int[2];
        return result;
        */
        
        // Optimal
        HashMap<Integer, Integer> values = new HashMap<>();
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (values.containsKey(nums[i])) {
                int j = values.get(nums[i]);
                result[0] = j;
                result[1] = i;
                return result;
            } else {
                values.put(target - nums[i], i); 
            }
        }
        
        return new int[2];
    }
}
