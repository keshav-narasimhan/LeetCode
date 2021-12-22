class Solution {
    /*
     * slow solution --> will try and improve upon it
     */
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> allSubsets = new HashSet<>();
        
        // trivial subset --> empty set
        allSubsets.add(new ArrayList<>());
        
        helper(nums, 0, allSubsets, null);
        List<List<Integer>> results = new ArrayList<>(allSubsets);
        return results;
    }
    
    public void helper(int[] nums, int index, HashSet<List<Integer>> allSubsets, List<Integer> ongoing) {
        if (index >= nums.length) {
            if (ongoing != null) {
                allSubsets.add(ongoing);   
            }
            return;
        }
        
        // one number list
        List<Integer> single = new ArrayList<>();
        single.add(nums[index]);
        allSubsets.add(single);
        helper(nums, index + 1, allSubsets, null);
        
        List<Integer> start = new ArrayList<>();
        start.add(nums[index]);
        helper(nums, index + 1, allSubsets, start);
        
        if (ongoing != null) {
            List<Integer> inc = new ArrayList<>(ongoing);
            List<Integer> not_inc = new ArrayList<>(ongoing);
            
            ongoing.add(nums[index]);
            allSubsets.add(ongoing);
            helper(nums, index + 1, allSubsets, not_inc);
            
            inc.add(nums[index]);
            helper(nums, index + 1, allSubsets, inc);
        }
        
    }
}
