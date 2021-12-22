class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
         * slower solution --> will try and make it much more efficient next go-around
         */
        List<List<String>> grpAnagrams = new ArrayList<>();
        HashSet<Integer> completedWords = new HashSet<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (!completedWords.contains(i)) {
                List<String> newAnagram = new ArrayList<>();
                String currWord = strs[i];
                newAnagram.add(currWord);
                completedWords.add(i);
                for (int j = i + 1; j < strs.length; j++) {
                    String compareWord = strs[j];
                    if (!completedWords.contains(j)) {
                        if (checkAnagram(currWord.toCharArray(), compareWord.toCharArray())) {
                            completedWords.add(j);
                            newAnagram.add(compareWord);
                        }   
                    }
                }
            
                grpAnagrams.add(newAnagram);
            }
        }
        
        return grpAnagrams;
    }
    
    public boolean checkAnagram(char[] str1, char[] str2) {
        if (str1.length != str2.length) {
            return false;
        }
        char[] check = new char[26];
        for (int i = 0; i < str1.length; i++) {
            check[str1[i] - 'a']++;
            check[str2[i] - 'a']--;
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
