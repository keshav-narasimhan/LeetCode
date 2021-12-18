class Solution {
    public int uniquePaths(int m, int n) {
        /*
         * Brute Force method of checking all options
         */
        // return helper(m - 1, n - 1);
        
        /*
         * more efficent dynamic programming strategy
         */
        // initialize table for DP
        int [][] Table  = new int[m][n];
        
        // preprocessing
        for (int i = 0; i < m; i++) {
            Table[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            Table[0][i] = 1;
        }
        
        // main loop
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                Table[i][j] = Table[i - 1][j] + Table[i][j - 1];
            }
        }
        
        // return total number of paths to get to m-1, n-1 matrix cell
        return Table[m - 1][n - 1];
    }
    
    // public int helper(int m, int n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     else if (m == 0) {
    //         return 1;
    //     } else {
    //         return helper(m - 1, n) + helper(m, n - 1);
    //     }
    // }
}
