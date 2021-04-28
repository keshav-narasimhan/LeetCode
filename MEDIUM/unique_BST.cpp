class Solution {
public:
    int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        } 
        if (n == 2) {
            return 2;
        }
        
        int sum = 0;
        for (int a = 1; a <= n; a++) {
            sum += numTrees(a - 1) * numTrees(n - a);
        }
        
        return sum;
    }
};