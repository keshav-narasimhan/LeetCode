class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        int start_r = 0;
        int end_r = n - 1;
        
        while (start_r < end_r) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[start_r][i];
                matrix[start_r][i] = matrix[end_r][i];
                matrix[end_r][i] = temp;
            }
            
            start_r++;
            end_r--;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
