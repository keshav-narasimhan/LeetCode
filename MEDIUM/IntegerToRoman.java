class Solution {
    public String intToRoman(int num) {
        // using StringBuilder instead of String makes for faster submission/less memory usage => using += with String creates new String objects
        /*String*/ StringBuilder integer_roman = new StringBuilder("");
        
        while(num > 0) {
            if (num - 1000 >= 0) {
                // integer_roman += "M";
                integer_roman.append("M");
                num -= 1000;
            } else if (num - 900 >= 0) {
                // integer_roman += "CM";
                integer_roman.append("CM");
                num -= 900;
            } else if (num - 500 >= 0) {
                // integer_roman += "D";
                integer_roman.append("D");
                num -= 500;
            } else if (num - 400 >= 0) {
                // integer_roman += "CD";
                integer_roman.append("CD");
                num -= 400;
            } else if (num - 100 >= 0) {
                // integer_roman += "C";
                integer_roman.append("C");
                num -= 100;
            } else if (num - 90 >= 0) {
                // integer_roman += "XC";
                integer_roman.append("XC");
                num -= 90;
            } else if (num - 50 >= 0) {
                // integer_roman += "L";
                integer_roman.append("L");
                num -= 50;
            } else if (num - 40 >= 0) {
                // integer_roman += "XL";
                integer_roman.append("XL");
                num -= 40;
            } else if (num - 10 >= 0) {
                // integer_roman += "X";
                integer_roman.append("X");
                num -= 10;
            } else if (num - 9 >= 0) {
                // integer_roman += "IX";
                integer_roman.append("IX");
                num -= 9;
            } else if (num - 5 >= 0) {
                // integer_roman += "V";
                integer_roman.append("V");
                num -= 5;
            } else if (num - 4 >= 0) {
                // integer_roman += "IV";
                integer_roman.append("IV");
                num -= 4;
            } else if (num - 1 >= 0) {
                // integer_roman += "I";
                integer_roman.append("I");
                num--;
            }
        }
        
        return integer_roman.toString();
    }
}
