// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
class Solution {
    public int strangePrinter(String s) 
    {
       int n=s.length();
       int dp[][]=new int[n][n];

       for(int i=0;i<n;i++)
           Arrays.fill(dp[i],-1);

       return minturns(s,0,n-1,dp);
    }

    public int minturns(String s,int start,int end,int dp[][]){
        
        if(start>end)
            return 0;
        
        if(dp[start][end]!=-1)
            return dp[start][end];

 
        int turns=1+minturns(s,start+1,end,dp);

        for(int k=start+1;k<=end;k++){
         
            if(s.charAt(start)==s.charAt(k))

                turns=Math.min(turns,minturns(s,start,k-1,dp)+minturns(s,k+1,end,dp));
        
        }
        dp[start][end]=turns;
        return turns;
    }
}