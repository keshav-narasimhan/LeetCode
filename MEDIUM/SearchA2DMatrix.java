class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0]) {
            return false;
        }
        
        int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }
        
        int left = 0;
        int right = matrix[0].length - 1;
        int middle = (left + right) / 2;
        
        while (left <= right) {
            middle = (left + right) / 2;
            
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return false;
    }
    
    private int findRow(int [][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        int middle = (up + down) / 2;
        
        while (up <= down) {
            middle = (up + down) / 2;
            
            if (target >= matrix[middle][0] && target <= matrix[middle][matrix[0].length - 1]) {
                return middle;
            }
            
            if (target < matrix[middle][0]) {
                down = middle - 1;
            } else {
                up = middle + 1;
            }
        }
        
        return -1;
    }
}
