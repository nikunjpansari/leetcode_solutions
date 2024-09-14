class Solution {
    public int longestSubarray(int[] nums) {
        int l=0, res = 0 , mx = 0;
        for(int i : nums)
        {
        mx = Math.max(i,mx);
        }
        for(int i : nums)
        {
            if(mx == i)
            res = Math.max(res,++l);
            else
            l = 0;
        }
        return res;
    }
}