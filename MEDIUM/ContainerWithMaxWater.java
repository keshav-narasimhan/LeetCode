class Solution {
    public int maxArea(int[] height) {
        // left ptr
        int leftWall = 0;
        
        // right ptr
        int rightWall = height.length - 1;
        
        // current max area
        int area = (rightWall - leftWall) * Math.min(height[leftWall], height[rightWall]);
        
        // loop to find max area
        while(leftWall < rightWall) {
            // area limited by shorter of two container walls => attempt to get larger area by moving the wall that is shorter currently
            if (height[leftWall] < height[rightWall]) {
                leftWall++;
                if (area < (rightWall - leftWall) * Math.min(height[leftWall], height[rightWall])) {
                    area = (rightWall - leftWall) * Math.min(height[leftWall], height[rightWall]);
                }
            } else {
                rightWall--;
                if (area < (rightWall - leftWall) * Math.min(height[leftWall], height[rightWall])) {
                    area = (rightWall - leftWall) * Math.min(height[leftWall], height[rightWall]);
                }
            }
        }
        
        // return max area
        return area;
    }
}
