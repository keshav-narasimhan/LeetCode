class Solution {
    public char findTheDifference(String s, String t) {
        int[] all_letters = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            all_letters[s.charAt(i) - 'a']++;
            all_letters[t.charAt(i) - 'a']--;
        }
        all_letters[t.charAt(s.length()) - 'a']--;
        
        for (int i = 0; i < 26; i++) {
            if (all_letters[i] == -1) {
                return (char)(i + 97);
            }
        }
        
        return 'a';
    }
}
