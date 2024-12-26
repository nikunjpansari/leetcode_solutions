class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum  = 0;

        for(int i = 0; i<nums.length;i++)
        sum += nums[i];

        if(sum - target < 0 || (sum -  target) % 2 == 1)
        return 0;

        return solve(nums,(sum-target)/2);
    }
    public int solve(int[] nums,int target)
    {
    int n = nums.length;

    int[] prev = new int[target+1];
    if(nums[0] == 0)
    prev[0] = 2;
    else
    prev[0] = 1;

    if(nums[0] != 0 && nums[0] <= target)
    prev[nums[0]] = 1;

    for(int i = 1; i < n ;i++)
    {
        int[] curr = new int[target+1];
        for(int j = 0 ; j <= target ; j++)
        {
            int notTaken = prev[j];
            int taken = 0;
            if(nums[i] <= j)
            taken = prev[j-nums[i]] ;

            curr[j] = (notTaken + taken);    
        }
        prev = curr;
    }
    return prev[target];
    }
}