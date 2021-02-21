/*
 * EASY 2/20/2021
 */
public class RunningSumof1DArray 
{
	public int[] runningSum(int[] nums) 
	{
        int [] run_sum = new int [nums.length];
        int sum = 0;
        
        for (int a = 0; a < nums.length; a++)
        {
            sum += nums[a];
            run_sum[a] = sum;
        }
        
        return run_sum;
    }
}
