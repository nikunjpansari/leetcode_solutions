class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0 ;
        int mn =-1;
        int mx =-1;
        int s =0 ;
        for(int i =0 ; i< nums.length;i++)
        {
            if(nums[i] < minK || nums[i]> maxK)
            {
                mn = -1;
                mx = -1;
                s = i+1;
            }
            if(nums[i] == minK)
            mn = i;
            if(nums[i] == maxK)
            mx = i;
             res += Math.max(0L, Math.min(mn,mx) - s + 1);
        }
    return res;
    }
}