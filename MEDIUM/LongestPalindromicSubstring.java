/*
 * Attempt 1 => bit of a slow solution
 */

// class Solution {
//     /*
//      * slow solution --> will try and make more efficient next time
//      */
//     public String longestPalindrome(String s) {
//         String longestPal = s.charAt(0) + "";
//         int lengthLongestPal = 1;
        
//         for (int i = 0; i < s.length() - 1; i++) {
//             char currChar = s.charAt(i);
//             for (int j = i + 1; j < s.length(); j++) {
//                 char compareChar = s.charAt(j);
//                 if ((j - i + 1 > lengthLongestPal) && currChar == compareChar) {
//                     if (isPalindrome(s, i, j)) {
//                         longestPal = s.substring(i, j + 1);
//                         lengthLongestPal = j - i + 1;
//                     }
//                 }
//             }
//         }
        
//         return longestPal;
//     }
    
//     public boolean isPalindrome(String s, int start, int end) {
//         while(start <= end) {
//             if (s.charAt(start) != s.charAt(end)) {
//                 return false;
//             } else {
//                 start++;
//                 end--;
//             }
//         }
        
//         return true;
//     }
// }



/*
 * Attempt 2 => faster runtime
 */

class Solution {
    public String longestPalindrome(String s) {
        // trivial base case
        if (s == null || s.length() == 0) {
            return "";
        }
        
        
        /*
         * main idea: obtain/check palindrome by branching out from the middle to the ends
         * 1. odd length --> start from middle elem & branch out
         * 2. even length --> start from middle 2 elems & branch out
         */
        
        // String to hold longest palindrome
        String longestPalindrome = s.charAt(0) + "";
        
        // loop through the string
        for (int i = 1; i < s.length(); i++) {
            // check for the 2 potential palindrome cases
            String odd = longestPalindromeHelper(s, i, i);
            String even = longestPalindromeHelper(s, i - 1, i);
            
            // update longestPalindrome if necessary
            if (odd.length() > longestPalindrome.length()) {
                longestPalindrome = odd;
            }
            if (even.length() > longestPalindrome.length()) {
                longestPalindrome = even;
            }
        }
        
        // return the longest palindrome
        return longestPalindrome;
    }
    
    // helper function to calculate the longest palindrome based off of the starting pts
    private String longestPalindromeHelper(String s, int leftMid, int rightMid) {
        if (leftMid > rightMid) {
            return "";
        }
        
        while (leftMid >= 0 && rightMid < s.length() && s.charAt(leftMid) == s.charAt(rightMid)) {
            leftMid--;
            rightMid++;
        }
        
        return s.substring(leftMid + 1, rightMid);
    }
}
