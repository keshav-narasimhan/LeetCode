class Solution {
    /*
    // brute force? less optimal for sure
    public List<List<String>> groupAnagrams(String[] strs) {
        HashSet<Integer> indices = new HashSet<>();
        List<List<String>> anagrams = new ArrayList<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (indices.contains(i)) {
                continue;
            }
            
            indices.add(i);
            String s = strs[i];
            int [] sCharCounts = getCharCounts(s);
            List<String> group = new ArrayList<>();
            group.add(s);
            
            for (int j = i + 1; j < strs.length; j++) {
                String o = strs[j];
                
                if (indices.contains(j) || o.length() != s.length()) {
                    continue;
                }
                
                boolean isAnagram = isAnagram(o, sCharCounts.clone());
                if (isAnagram) {
                    group.add(o);
                    indices.add(j);
                }
            }
            
            anagrams.add(group);
        }
        
        return anagrams;
    }
    
    public int[] getCharCounts(String str) {
        int [] charCounts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charCounts[str.charAt(i) - 'a']++;
        }
        return charCounts;
    }
    
    public boolean isAnagram(String o, int [] charCounts) {
        for (int i = 0; i < o.length(); i++) {
            charCounts[o.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    */
    
    // optimal
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String, List<String>> groups = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char [] sCharArray = s.toCharArray();
            Arrays.sort(sCharArray);
            String key = new String(sCharArray);
            
            if (groups.containsKey(key)) {
                List<String> group = groups.get(key);
                group.add(s);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                anagrams.add(newGroup);
                groups.put(key, newGroup);
            }
        }
                
        return anagrams;
    }
}
