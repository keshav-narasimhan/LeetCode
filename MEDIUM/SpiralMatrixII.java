class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int val = 1;
        
        int leftCol = 0;
        int rightCol = n - 1;
        int topRow = 0;
        int bottomRow = n - 1;
        
        while (leftCol <= rightCol && topRow <= bottomRow) {
            for (int i = leftCol; i <= rightCol; i++) {
                matrix[topRow][i] = val;
                val++;
            }
            
            for (int i = topRow + 1; i <= bottomRow; i++) {
                matrix[i][rightCol] = val;
                val++;
            }
            
            if (topRow != bottomRow) {
                for (int i = rightCol - 1; i >= leftCol; i--) {
                    matrix[bottomRow][i] = val;
                    val++;
                }
            }
            
            if (leftCol != rightCol) {
                for (int i = bottomRow - 1; i > topRow; i--) {
                    matrix[i][leftCol] = val;
                    val++;
                }
            }
            
            leftCol++;
            rightCol--;
            topRow++;
            bottomRow--;
        }
        
        return matrix;
    }
}
