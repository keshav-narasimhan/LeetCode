class Solution {
    public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> largeNums = new PriorityQueue<>();
//         for (int i = 0; i < nums.length; i++) {
//             largeNums.add(nums[i]);
//         }
        
//         int KthLargest = Integer.MIN_VALUE;
//         for (int i = 0; i <= nums.length - k; i++) {
//             KthLargest = largeNums.poll();
//         }
        
//         return KthLargest;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        Collections.sort(arr);
        return arr.get(nums.length - k);
    }
}
