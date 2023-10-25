//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        int sum = 0;
        for(int i = 0; i<N;i++)
        sum += A[i];
        
        if(sum - target < 0 || (sum - target) % 2 == 1)
        return 0;
        
        return solve(A,(sum-target)/2);
    }
    public static int solve(int[] A , int target)
    {
        int n = A .length;
        int[] prev  = new int[target + 1];
        
        if(A[0] == 0)
        prev[0] = 2;
        else
        prev[0] = 1;
        
        if(A[0] != 0 && A[0] <= target)
        prev[A[0]] = 1;
        
        for(int i = 1 ; i < n ; i++)
        {
            int[] curr = new int[target + 1];
            for(int j = 0 ; j <= target ;j++)
            {
                int notTaken = prev[j];
                
                int taken = 0 ;
                if(A[i] <= j)
                taken = prev[j-A[i]];
                
                curr[j] = notTaken +  taken;
            }
            prev = curr;
        }
        return prev[target];
    }
};