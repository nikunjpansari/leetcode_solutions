class Solution {
  public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (-target <= nums[i] - nums[j] && nums[i] - nums[j] <= target) {
                    if (dp[j] > -1) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}