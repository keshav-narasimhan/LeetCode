class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");  
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> patternMatching = new HashMap<>();
        HashSet<String> allWords = new HashSet<>();
        char curr;
        for (int chars = 0; chars < pattern.length(); chars++) {
            curr = pattern.charAt(chars);
            if (!patternMatching.containsKey(curr)) {
                if (allWords.contains(words[chars])) {
                    return false;
                }
                allWords.add(words[chars]);
                patternMatching.put(curr, words[chars]);
            } else {
                String patternWord = patternMatching.get(curr);
                if (!words[chars].equals(patternWord)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
