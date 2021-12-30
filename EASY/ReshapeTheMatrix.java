class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // case when matrix is unable to be reshaped to specified boundaries
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        
        // declare dimensions for new matrix
        int [][] new_mat = new int[r][c];
        int r_ind = 0;
        int c_ind = 0;
        
        // loop to populate new_mat with values from given matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (c_ind < c) {
                    new_mat[r_ind][c_ind] = mat[i][j];
                    c_ind++;
                } else {
                    r_ind++;
                    c_ind = 0;
                    new_mat[r_ind][c_ind] = mat[i][j];
                    c_ind++;
                }
            }
        }
        
        // return the new, reshaped matrix
        return new_mat;
    }
}
