class Solution {
    Integer[] dp;
    public int solve(int[] nums, int d, int i){
        if(dp[i]!=null) return dp[i];

        int res = 0;

        for(int x=1; x<=d; x++){
            if(i+x>=nums.length || nums[i]<=nums[i+x]) break;
            int a = solve(nums, d, i+x);
            res = Math.max(res, a);
        }

        for(int x=1; x<=d; x++){
            if(i-x<0 || nums[i]<=nums[i-x]) break;
            int b = solve(nums, d, i-x);
            res = Math.max(res, b);
        }

        res = res+1; 
        return dp[i] = res;
    }
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        dp = new Integer[arr.length];

        for(int i=0; i<arr.length; i++){
            int res = solve(arr, d, i);
            max = Math.max(max, res);
        }
        return max;
    }
}