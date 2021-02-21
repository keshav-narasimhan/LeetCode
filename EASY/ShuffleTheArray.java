/*
 * EASY 2/20/2021
 */

public class ShuffleTheArray 
{
	public int[] shuffle(int[] nums, int n) 
	{
        
        int [] shuffled_arr = new int [nums.length];
        int index = 0;
        
        for (int a = 0; a < n; a++)
        {
            shuffled_arr[index] = nums[a];
            index++;
            shuffled_arr[index] = nums[a + n];
            index++;
        }
        
        return shuffled_arr;
    }
}
