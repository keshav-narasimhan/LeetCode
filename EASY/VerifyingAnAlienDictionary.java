class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // simple base case 
        if (words.length == 1) {
            return true;
        }
        
        // HashMap of characters
        HashMap<Character, Integer> char_order = new HashMap<>();
        
        // populate HashMap
        for(int i = 0; i < order.length(); i++) {
            char_order.put(order.charAt(i), i + 1);
        }
        
        // variables used in main loop
        String prev;
        String curr;
        int index;
        char char_prev;
        char char_curr;
        
        // main loop
        for(int i = 1; i < words.length; i++) {
            // get the current word and the previous word
            prev = words[i - 1];
            curr = words[i];
            index = 0;
            
            // loop through the characters of both 'prev' & 'curr'
            while(index < prev.length() && index < curr.length()) {
                // get the char at 'index'
                char_prev = prev.charAt(index);
                char_curr = curr.charAt(index);
                
                // if not in order => return false
                if (char_order.get(char_curr) < char_order.get(char_prev)) {
                    return false;
                } 
                // if in order at the current character => move on to next pair of words
                else if (char_order.get(char_curr) > char_order.get(char_prev)) {
                    break;
                } 
                // move to next character if the current chars are equal
                else {
                    index++;   
                }
            }
            
            // if all preceding chars match & curr is longer than prev => return false
            if (index < prev.length() && index == curr.length()) {
                return false;
            }
        }
        
        // reach the end of words array => return true
        return true;
    }
}
