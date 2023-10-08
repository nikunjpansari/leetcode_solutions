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
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int A[] = new int[n];
                    int B[] = new int[m];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    for(int i = 0;i<m;i++)
                        B[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxDotProduct(n, m, A, B));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
public int maxDotProduct(int n, int m, int[] A, int[] B) {
    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dp[i][j] = -1;
        }
    }

    return solve(n - 1, m - 1, A, B, dp);
}

public int solve(int i, int j, int[] a, int[] b, int[][] dp) {
    if (i < 0 || j < 0) {
        return 0;
    }

    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    int take = a[i] * b[j] + solve(i - 1, j - 1, a, b, dp);
    int notTake = (i == j) ? 0 : solve(i - 1, j, a, b, dp);

    dp[i][j] = Math.max(take, notTake);
    return dp[i][j];
}
 
}
