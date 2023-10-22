class Solution {
    public int minimumSum(int[] nums) {
         int[] l = new int[nums.length], r = new int[nums.length];
        Arrays.fill(l, Integer.MAX_VALUE);
        Arrays.fill(r, Integer.MAX_VALUE);

        for (int i = 1; i < nums.length; i++) 
        {
            l[i] = Math.min(nums[i - 1], l[i - 1]);
            r[nums.length - 1 - i] = Math.min(nums[nums.length - i], r[nums.length - i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length - 1; i++) 
        {
            int cs = Integer.MAX_VALUE;
            if (l[i] != Integer.MAX_VALUE && r[i] != Integer.MAX_VALUE
                    && nums[i] > l[i] && r[i] < nums[i]
            ) cs = l[i] + r[i] + nums[i];

            ans = Math.min(ans, cs);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}