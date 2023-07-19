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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java
// Time Complexity : O(|S|*|S|)
// Space Complexity : O(|S|*|S|)
class Solution
{
    public int longestPalinSubseq(String s)
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) 
        {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) 
                    dp[i][j] = 2 + dp[i+1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        
        return dp[0][n-1];
    }
}