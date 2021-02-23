/*
 * EASY 2/23/2021
 */

public class SumAllOddLengthArrays 
{
	public int sumOddLengthSubarrays(int[] arr) {
        
        int isEvenOrOdd = 0;
        if (arr.length % 2 == 0)
            isEvenOrOdd = arr.length/2;
        else
            isEvenOrOdd = arr.length/2 + 1;
        
        int odd_counter = 0;
        int sum = 0;
        
        for (int a = 0; a < isEvenOrOdd; a++)
        {
            for (int b = 0; b < arr.length - odd_counter; b++)
            {
                for (int c = b; c < b + odd_counter + 1; c++)
                {
                    sum += arr[c];
                }
            }
            odd_counter += 2;
        }
        
        return sum;    
    }
}
