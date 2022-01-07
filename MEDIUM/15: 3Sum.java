class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // trivial base case => no triplets exist
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        
        // sort the array => O(nlog(n)) time
        Arrays.sort(nums);
        
        // initialize the 2D list to be returned
        List<List<Integer>> triplets = new ArrayList<>();
        
        // variables used in loop
        int ind1;
        int ind2;
        int ind3;
        int currSum;
        
        // main loop to calculate all of the triplets
        for (int i = 0; i < nums.length - 2; i++) {
            // checking for duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                ind1 = i;
                ind2 = i + 1;
                ind3 = nums.length - 1;
                
                // 2Sum + nums[ind1]
                while (ind2 < ind3) {
                    currSum = nums[ind1] + nums[ind2] + nums[ind3];
                    if (currSum == 0) {
                        // add the new triplet pair to the list
                        List<Integer> new_triplet = new ArrayList<>();
                        new_triplet.add(nums[ind1]); 
                        new_triplet.add(nums[ind2]); 
                        new_triplet.add(nums[ind3]);
                        triplets.add(new_triplet);
                    
                        // find the new indices for 'ind2' & 'ind3'
                        ind2++;
                        ind3--;
                        while (ind2 < nums.length && nums[ind2] == nums[ind2 - 1])
                            ind2++;
                    
                        while (ind3 > i && nums[ind3] == nums[ind3 + 1]) 
                            ind3--;
                    
                    } else if (currSum < 0) {
                        // find the new index for 'ind2'
                        ind2++;
                        while (ind2 < nums.length && nums[ind2] == nums[ind2 - 1])
                            ind2++;
                    
                    } else {
                        // find the nex index for 'ind3'
                        ind3--;
                        while (ind3 > i && nums[ind3] == nums[ind3 + 1]) 
                            ind3--;
                    
                    }
                }
            }
            
        }
        
        // return the list of triplets
        return triplets;
    }
}
