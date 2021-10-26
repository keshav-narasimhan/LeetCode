class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int [] M = new int[n];
        M[0] = 1;
        M[1] = 2;
        for (int i = 2; i < n; i++) {
            if (M[i] == 0) {
                M[i] = M[i-2] + M[i-1];
            }
        }
        
        return M[n - 1];
    }
}
