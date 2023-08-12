//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long mod = 1000000007;
    public int totalWays(int N, int M, int grid[][]) {
        // Code here
      
       long prev[] = new long[M];
       Arrays.fill(prev,0);
      for(int i = 0;i<N;i++){
          long curr[]=new long[M];
          Arrays.fill(curr,0);
          for(int j= 0;j<M;j++){
                if(grid[i][j]==1){
                  curr[j]=0;
              }
              else if(i==0&&j==0){
                                       curr[j]=1;
                            }
              
              else{
                  long up = 0;
                  long left = 0;
                  if(i>0)up=prev[j];
                  if(j>0)left = curr[j-1];
                  curr[j]=(up+left)%mod;
              }
          }
          prev=curr;
      }
        return (int)(prev[M-1]%mod);


    }
}
