class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int y = reverseNum(x, 0);
            return (x == y) ? true : false;
        }
    }
    
    public int reverseNum(int n, int r) {
        if (n == 0) {
            return r;
        } else {
            return reverseNum(n / 10, 10 * r + (n % 10));
        }
    }
}
