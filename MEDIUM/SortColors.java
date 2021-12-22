class Solution {
    public void sortColors(int[] nums) {
        /*
         * variables to keep count of each color
         */
        int numReds = 0;
        int numWhites = 0;
        int numBlues = 0;
        
        /*
         * figure out how many of each color are in the array
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numReds++;
            } else if (nums[i] == 1) {
                numWhites++;
            } else if (nums[i] == 2) {
                numBlues++;
            }
        }
        
        /*
         * overwrite the array based on the counts from last pass
         */
        for (int i = 0; i < nums.length; i++) {
            if (numReds > 0) {
                nums[i] = 0;
                numReds--;
            } else if (numWhites > 0) {
                nums[i] = 1;
                numWhites--;
            } else if (numBlues > 0) {
                nums[i] = 2;
                numBlues--;
            }
        }
        
        /*
         * O(n) time complexity because of linear traversal through array
         */
    }
}
