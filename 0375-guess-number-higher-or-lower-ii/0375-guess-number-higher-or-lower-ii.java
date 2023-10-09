class Solution {
      public int getMoneyAmount(int n) 
      {
        if(n==1)
            return 0;

        int[][] dp = new int[n+1][n+1];
        return solve(1,n,dp);
    }
    private int solve(int s,int e,int[][] dp)
    {
        if(s > e)
            return Integer.MIN_VALUE;
    
        if(s == e)
            return 0;
        
        if(dp[s][e] != 0)
            return dp[s][e];
        
        int min = Integer.MAX_VALUE;
        for(int i=s;i<=e-1;i++)
        {
            int max = i + Math.max(solve(s,i-1,dp),solve(i+1,e,dp));
            min = Math.min(min,max);
        }
        return dp[s][e] = min;
    }
}