class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int numNine = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 9) {
                numNine++;
            }
        }
        
        if (numNine == length) {
            length++;
        }
        
        int[] result = new int[length];
        int resultIndex = length - 1;
        int carry = 1;
        for (int index = digits.length - 1; index > -1; index--) {
            int num = carry + digits[index];
            if (num < 10) {
                carry = 0;
                result[resultIndex] = num;
            } else {
                result[resultIndex] = 0;
            }
            
            resultIndex--;
        }
        
        if (resultIndex != -1) {
            result[resultIndex] = carry;
        }
        
        return result;
    }
}
