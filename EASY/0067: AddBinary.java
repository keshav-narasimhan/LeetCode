class Solution {
    public String addBinary(String a, String b) {
        // resulting binary number 
        StringBuilder answer = new StringBuilder("");
        
        // indices for iteration
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        
        // variables used in algorithm
        char charA;
        char charB;
        char carryIn = '0';
        
        // add the binary strings while the indices are in bounds
        while (indexA >= 0 && indexB >= 0) {
            charA = a.charAt(indexA);
            charB = b.charAt(indexB);
            
            if (carryIn == '0') {
                if ( (charA == '0' && charB == '1') || (charA == '1' && charB == '0') ) {
                    answer.insert(0, '1');
                    carryIn = '0';
                } else if (charA == '0' && charB == '0') {
                    answer.insert(0, '0');
                    carryIn = '0';
                } else {
                    answer.insert(0, '0');
                    carryIn = '1';
                }
            } else {
                if ( (charA == '0' && charB == '1') || (charA == '1' && charB == '0') ) {
                    answer.insert(0, '0');
                    carryIn = '1';
                } else if (charA == '0' && charB == '0') {
                    answer.insert(0, '1');
                    carryIn = '0';
                } else {
                    answer.insert(0, '1');
                    carryIn = '1';
                }
            }
            
            indexA--;
            indexB--;
        }
        
        // account for the case where there are still numbers in binary number a
        while(indexA >= 0) {
            charA = a.charAt(indexA);
            
            if (carryIn == '0') {
                if (charA == '0') {
                    answer.insert(0, '0');
                } else {
                    answer.insert(0, '1');
                }
                carryIn = '0';
            } else {
                if (charA == '0') {
                    answer.insert(0, '1');
                    carryIn = '0';
                } else {
                    answer.insert(0, '0');
                    carryIn = '1';
                }
            }
            
            indexA--;
        }
        
        // account for the case where there are still numbers in binary number b
        while(indexB >= 0) {
            charB = b.charAt(indexB);
            
            if (carryIn == '0') {
                if (charB == '0') {
                    answer.insert(0, '0');
                } else {
                    answer.insert(0, '1');
                }
                carryIn = '0';
            } else {
                if (charB == '0') {
                    answer.insert(0, '1');
                    carryIn = '0';
                } else {
                    answer.insert(0, '0');
                    carryIn = '1';
                }
            }
            
            indexB--;
        }
        
        // account for a carry out of 1
        if (carryIn == '1') {
            answer.insert(0, '1');
        }
        
        // return the resulting binary number after addition
        return answer.toString();
    }
}
