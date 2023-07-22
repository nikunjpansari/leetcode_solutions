//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public double findProb(int N, int start_x, int start_y, int step) {
        int[][] dir = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};

        double[][][] dp = new double[step + 1][N][N];
        dp[0][start_x][start_y] = 1.0;
        int prevI;
        int prevJ;
        for (int m = 1; m <= step; m++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] d : dir) {
                        prevI = i - d[0];
                        prevJ = j - d[1];
                        if (prevI >= 0 && prevI < N && prevJ >= 0 && prevJ < N) {
                            dp[m][i][j] += dp[m - 1][prevI][prevJ] / 8.0;
                        }
                    }
                }
            }
        }

        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += dp[step][i][j];
            }
        }
        return ans;
    }

}