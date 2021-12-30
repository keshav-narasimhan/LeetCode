class Solution {
    public String getHint(String secret, String guess) {
        // initialize variables for algorithm
        int numBulls = 0;
        int numCows = 0;
        int[] letters = new int[10];
        int[] letters_count = new int[10];
        
        // main loop for detecting 'bull' chars & potential 'cow' chars
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                numBulls++;
            } else {
                letters[secret.charAt(i) - '0']++;
                letters[guess.charAt(i) - '0']--;
                letters_count[secret.charAt(i) - '0']++;
                letters_count[guess.charAt(i) - '0']++;
            }
        }
            
        // calculate cow chars
        for (int i = 0; i < 10; i++) {
            numCows += (letters_count[i] - Math.abs(letters[i])) / 2;
        }
    
        // return the final hint string
        return numBulls + "A" + numCows + "B";
    }
}
