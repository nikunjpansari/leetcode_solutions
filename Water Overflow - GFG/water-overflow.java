//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int K = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int C = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.printf("%.6f\n" , ob.waterOverflow(K,R,C));
        }
    }
}
// } Driver Code Ends

// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
class Solution {
    public static double waterOverflow(int K, int R, int C) {
        double[][] dp = new double[K + 1][K + 1];
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = 0.0;
            }
        }
        dp[0][0] = K;

        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (dp[i][j] > 1) {
                    double dummy = dp[i][j] - 1;
                    dp[i][j] = 1;
                    dummy = dummy / 2.0;
                    dp[i + 1][j] += dummy;
                    dp[i + 1][j + 1] += dummy;
                }
            }
        }

        return dp[R - 1][C - 1];
    }
}