class Solution {
    public List<Integer> partitionLabels(String s) {
        // initialize an popupulate a HashMap of the last index positions of each char
        HashMap<Character, Integer> lastPos = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!lastPos.containsKey(s.charAt(i))) {
                lastPos.put(s.charAt(i), i);
            }
        }
        
        // initialize variables to return answer + use in loop
        List<Integer> labels = new ArrayList<>();
        int indexChar = 0;
        int endOfPartition = lastPos.get(s.charAt(0));
        
        // main loop for algorithm
        while (indexChar < s.length()) {
            // get the current partition end
            endOfPartition = lastPos.get(s.charAt(indexChar));
            
            // update the partition ending by going through each letter
            for (int i = indexChar + 1; i < endOfPartition; i++) {
                if (lastPos.get(s.charAt(i)) > endOfPartition) {
                    endOfPartition = lastPos.get(s.charAt(i));
                }
            }
            
            // add the length of the partition to the list to be returned
            labels.add(endOfPartition - indexChar + 1);
            indexChar = endOfPartition + 1;
        }
        
        // return the list of partition lengths
        return labels;
    }
}
