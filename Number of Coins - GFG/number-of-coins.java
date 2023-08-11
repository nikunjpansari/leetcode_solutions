//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

 public int minCoins(int coins[], int n, int v) {
        int  dp[][]=new int[n+1][v+1];
        dp[0][0]=0;
        for(int i=1;i<=n;i++)
        dp[i][0]=0;
        
        for(int j=1;j<=v;j++)
        dp[0][j]=Integer.MAX_VALUE-1;
        
        
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=v;j++){
                if(coins[i-1]<=j)
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        
          int  ans=dp[n][v];
           if(ans==Integer.MAX_VALUE-1)
           return -1;
           
           return ans;
    } 
}