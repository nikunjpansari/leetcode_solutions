//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      int ans = obj.uglyNumber(n);
      System.out.println(ans);
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int uglyNumber(int n) {
     int c2 = 0,c3 = 0,c5 = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            dp[i] = Math.min(2*dp[c2],Math.min(3*dp[c3],dp[c5]*5));
            if(dp[i] == 2*dp[c2])
                c2++;
            if(dp[i] == 3*dp[c3])
                c3++;
            if(dp[i] == 5*dp[c5])
                c5++;
        }
        return dp[n-1];

  }
}
     