class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxi=0,count=0;
        for(int i=0,j=0;i<nums.length-1;i++)
        {
            if(nums[i] < nums[i+1])
            {
                count++;
                maxi=Math.max(maxi,count);
            }
            else
            {
                count=0;
            }
        }
        maxi=Math.max(maxi,count);
        count=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i] > nums[i+1])
            {
                count++;
                maxi=Math.max(maxi,count);
            }
            else
            {
                count=0;
            }
        }
        maxi=Math.max(maxi,count);
        return maxi+1;
    }
}