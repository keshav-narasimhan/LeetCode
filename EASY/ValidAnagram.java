class Solution {
    public boolean isAnagram(String s, String t) {
        // trivial
        if (s.length() != t.length()) {
            return false;
        }
        
        // declare a new char array to store the counts of each character in both strings
        int totalCount[] = new int[26];
        
        // one pass algorithm the find the count of each character in both strings (offsets each other)
        for (int i = 0; i < s.length(); i++) {
            totalCount[s.charAt(i) - 'a']++;
            totalCount[t.charAt(i) - 'a']--;
        }
        
        // check to see both offset each other exactly
        for (int i = 0; i < 26; i++) {
            if (totalCount[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
