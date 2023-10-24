//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String s)
    {
    if (s == null || s.length() == 0) {
        return 0;
    }

    int n = s.length();

    boolean[][] dp = buildMatrix(s, n);
    int[] totalCuts = new int[n];

    for (int j = 0; j < n; j++) {
        int cut = j;
        for (int i = 0; i <= j; i++) {
            if (dp[i][j]) {
                cut = (i == 0) ? 0 : Math.min(cut, totalCuts[i - 1] + 1);
            }
        }
        totalCuts[j] = cut;
    }

    return totalCuts[n - 1];
}

static boolean[][] buildMatrix(String s, int n) {
    boolean[][] dp = new boolean[n][n];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
            }
        }
    }

    return dp;
}

}