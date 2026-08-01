class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length,sum=0;
        int[][]arr=new int[n][n];
        for(int val:nums)sum+=val;
        return helper(nums,arr,0,n-1)>=0;
    }
    public int helper(int[]arr,int[][]dp,int start,int end){
        if(start==end)return arr[start];
        if(dp[start][end]!=0)return dp[start][end];
        int takeStart=arr[start]-helper(arr,dp,start+1,end);
        int takeEnd=arr[end]-helper(arr,dp,start,end-1);
        return dp[start][end]=Math.max(takeStart,takeEnd);
    }
}