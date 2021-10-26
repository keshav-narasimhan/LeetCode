class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<String>();
        }
        
        int number = Integer.valueOf(digits);
        ArrayList<String> combos = new ArrayList<>();
        generateCombos(combos, number, "");
        return combos;
    }
    
    private void generateCombos(ArrayList<String> combos, int n, String currNum) {
        if (n == 0) {
            combos.add(currNum);
        }
        
        int rem = n % 10;
        if (rem == 2) {
            generateCombos(combos, n / 10, "a" + currNum);
            generateCombos(combos, n / 10, "b" + currNum);
            generateCombos(combos, n / 10, "c" + currNum);
        } else if (rem == 3) {
            generateCombos(combos, n / 10, "d" + currNum);
            generateCombos(combos, n / 10, "e" + currNum);
            generateCombos(combos, n / 10, "f" + currNum);
        } else if (rem == 4) {
            generateCombos(combos, n / 10, "g" + currNum);
            generateCombos(combos, n / 10, "h" + currNum);
            generateCombos(combos, n / 10, "i" + currNum);
        } else if (rem == 5) {
            generateCombos(combos, n / 10, "j" + currNum);
            generateCombos(combos, n / 10, "k" + currNum);
            generateCombos(combos, n / 10, "l" + currNum);
        } else if (rem == 6) {
            generateCombos(combos, n / 10, "m" + currNum);
            generateCombos(combos, n / 10, "n" + currNum);
            generateCombos(combos, n / 10, "o" + currNum);
        } else if (rem == 7) {
            generateCombos(combos, n / 10, "p" + currNum);
            generateCombos(combos, n / 10, "q" + currNum);
            generateCombos(combos, n / 10, "r" + currNum);
            generateCombos(combos, n / 10, "s" + currNum);
        } else if (rem == 8) {
            generateCombos(combos, n / 10, "t" + currNum);
            generateCombos(combos, n / 10, "u" + currNum);
            generateCombos(combos, n / 10, "v" + currNum);
        } else if (rem == 9) {
            generateCombos(combos, n / 10, "w" + currNum);
            generateCombos(combos, n / 10, "x" + currNum);
            generateCombos(combos, n / 10, "y" + currNum);
            generateCombos(combos, n / 10, "z" + currNum);
        }
    }
}
