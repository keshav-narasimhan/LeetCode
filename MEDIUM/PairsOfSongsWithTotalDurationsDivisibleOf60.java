class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int numPairs = 0;
        HashMap<Integer, Integer> musicTimes = new HashMap<>();
        
        int times;
        for (int i = 0; i < time.length; i++) {
            int div60 = time[i] % 60;
            int rem = (60 - div60) % 60;
            
            if (musicTimes.containsKey(div60)) {
                times = musicTimes.get(div60);
                musicTimes.put(div60, times + 1);
            } else {
                musicTimes.put(div60, 1);
            }
            
            if (musicTimes.containsKey(rem)) {
                numPairs += musicTimes.get(rem);
                if (div60 == 30 || div60 == 0) {
                    numPairs--;
                }
            }
        }
        
        return numPairs;
    }
}
