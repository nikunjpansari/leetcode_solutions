class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = -x;

        for(int i:nums)
        target+=i;

        if(target==0)
        return n;
        
        if(target < 0)
        return -1;

        int res = -1,sum = 0,i=0;

        for(int j =0;j<n;j++)
        {
            sum += nums[j];

            while(sum > target)
            sum-=nums[i++];

            if(sum == target)
            res=Math.max(res , j-i+1);

        }

        return res==-1 ? -1 : n-res;

    }
}