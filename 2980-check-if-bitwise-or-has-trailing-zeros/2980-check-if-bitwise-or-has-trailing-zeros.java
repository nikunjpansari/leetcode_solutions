class Solution {
    public boolean hasTrailingZeros(int[] nums) 
    {
        int even = 0 ;
        for(int i : nums)
        {
        if(i % 2 == 1)
        even += 0;
        else
        even += 1;
        }
        return (even >= 2);
    }
}