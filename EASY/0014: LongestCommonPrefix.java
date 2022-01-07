class Solution {
    public String longestCommonPrefix(String[] strs) {
        // trivial base case
        if (strs[0].length() == 0) {
            return "";
        }
        
        // initialize a StringBuilder to build the prefix string
        StringBuilder prefix = new StringBuilder("");
        
        // loop through the letters of the first word in strs
        for (int i = 0; i < strs[0].length(); i++) {
            // obtain the current character
            char c = strs[0].charAt(i);
            
            // loop through the rest of the strings
            for (int j = 1; j < strs.length; j++) {
                // if other word is shorter than the current index, return the prefix
                if (i >= strs[j].length()) {
                    return prefix.toString();
                } 
                // if the characters don't match, return the prefix
                else if (strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }
            
            // if have reached the end of strs, append this character to the prefix and continue
            prefix.append(c);
        }
        
        // return the longest common prefix
        return prefix.toString();
    }
}
