class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int res = 0;
        int l = nums.length;
        int sub = 1<<l;
        Arrays.sort(nums);
        for(int i=1 ; i < sub ; i++)
        {
            int j = 0;
            int curr = i;
            boolean[] vis = new boolean[nums[l-1] + 1];
            boolean t = true;
            while(curr > 0)
            {
                if((curr & 1) == 1)
                {
                    if(nums[j] - k >=0 && vis[nums[j] -k])
                    {
                        t = false;
                        break;
                    }
                    vis[nums[j]] = true;
                }
                j++;
                curr>>=1;
            }
            if(t)
                res++;
        }
        return res;
    }
}