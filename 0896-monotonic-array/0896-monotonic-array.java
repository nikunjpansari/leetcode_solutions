class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean p = false , n = false;
        for(int i = 1 ;i < nums.length;i++)
        {
            if(nums[i] < nums[i-1])
            n = true;

            if(nums[i-1] < nums[i])
            p = true;
        }
        return p && n ? false : true;
    }
}