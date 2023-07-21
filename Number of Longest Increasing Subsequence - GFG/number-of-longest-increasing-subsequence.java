//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int n , int[] nums) {
        
        int [] dp = new int[n];
        int [] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count,1);
        int max = 1;
        
        for (int i = 1; i < n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (nums[i] > nums[j]) 
                {
                        if (dp[j] + 1 > dp[i]) 
                        {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        } 
                        else if (dp[j] + 1 == dp[i]) 
                            count[i] += count[j];
        
                max = Math.max(dp[i],max);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) 
        {
            if (dp[i] == max) 
                ans += count[i];
        }
        return ans;
       
}
    
}