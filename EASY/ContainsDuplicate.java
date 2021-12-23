class Solution {
    public boolean containsDuplicate(int[] nums) {
        // utilize a hashset to check whether array elems are already contained
        HashSet<Integer> dups = new HashSet<>();
        
        // traverse array
        for (int i = 0; i < nums.length; i++) {
            // if the set already contains the elem --> duplicate exists
            if (dups.contains(nums[i])) {
                return true;
            } 
            // if the set doesn't contain the elem --> add elem to the set
            else {
                dups.add(nums[i]);
            }
        }
        
        // no duplicate exists
        return false;
    }
}
