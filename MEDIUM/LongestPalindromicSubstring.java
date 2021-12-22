class Solution {
    /*
     * slow solution --> will try and make more efficient next time
     */
    public String longestPalindrome(String s) {
        String longestPal = s.charAt(0) + "";
        int lengthLongestPal = 1;
        
        for (int i = 0; i < s.length() - 1; i++) {
            char currChar = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char compareChar = s.charAt(j);
                if ((j - i + 1 > lengthLongestPal) && currChar == compareChar) {
                    if (isPalindrome(s, i, j)) {
                        longestPal = s.substring(i, j + 1);
                        lengthLongestPal = j - i + 1;
                    }
                }
            }
        }
        
        return longestPal;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}
