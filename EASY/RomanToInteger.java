class Solution {
    public int romanToInt(String s) {
        int roman_integer = 0;
        int index = 0;
        
        HashMap<String, Integer> subtractionInstances = new HashMap<>();
        subtractionInstances.put("IV", 4);
        subtractionInstances.put("IX", 9);
        subtractionInstances.put("XL", 40);
        subtractionInstances.put("XC", 90);
        subtractionInstances.put("CD", 400);
        subtractionInstances.put("CM", 900);
        subtractionInstances.put("I", 1);
        subtractionInstances.put("V", 5);
        subtractionInstances.put("X", 10);
        subtractionInstances.put("L", 50);
        subtractionInstances.put("C", 100);
        subtractionInstances.put("D", 500);
        subtractionInstances.put("M", 1000);
        
        while (index < s.length()) {
            // can try to find substring in subtractionInstances
            if (index < s.length() - 1) {
                String sub = s.substring(index, index + 2);
                if (subtractionInstances.containsKey(sub)) {
                    roman_integer += subtractionInstances.get(sub);
                    index += 2;
                } else {
                    roman_integer += subtractionInstances.get(s.substring(index, index + 1));
                    index++;
                }
            } else {
                roman_integer += subtractionInstances.get(s.substring(index, index + 1));
                index++;
            }
        }
        
        return roman_integer;
    }
}
