class Solution {
    public List<String> fizzBuzz(int n) {
        // output list
        ArrayList<String> output = new ArrayList<>();
        
        // iterate through each of the 'n' numbers
        for (int index = 1; index <= n; index++) {
            if (index % 3 == 0 && index % 5 == 0) {
                output.add("FizzBuzz");
            } else if (index % 3 == 0) {
                output.add("Fizz");
            } else if (index % 5 == 0) {
                output.add("Buzz");
            } else {
                output.add(String.valueOf(index));
            }
        }
        
        // return Fizz Buzz list
        return output;
    }
}
