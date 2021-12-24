class Solution {
    public int repeatedNTimes(int[] nums) {
        // used for unique elements
        HashSet<Integer> repeats = new HashSet<>();
        
        // check to see which elem is the N-repeated element
        for (int i = 0; i < nums.length; i++) {
            if (repeats.contains(nums[i])) {
                return nums[i];
            } else {
                repeats.add(nums[i]);
            }
        }
        
        // will never reach this point
        return -1;
    }
}
