//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(String S1, String S2) { 
       int n =  S1.length();
       int m =  S2.length();
       
       int[][] dp = new int[n+1][m+1];
       for(int i=0;i<=n;i++)
       dp[i][0]=1;
       
       for(int i=1;i<=n;i++)
       {
           for(int j =1;j<=m;j++)
           {
             if(S1.charAt(i-1) == S2.charAt(j-1))
             dp[i][j] =  dp[i-1][j-1] + dp[i-1][j];
             else
             dp[i][j] = dp[i-1][j];
       }
    }
    return dp[n][m];
}
}