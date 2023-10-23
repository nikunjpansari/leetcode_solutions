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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int a[], int n)  
	{  

      int[] dp = new int[n];
        for(int i = 0;i < n;i++) 
            dp[i] = a[i];
           
        for(int i = 0;i < n;i++)
        {
            for(int j = 0; j < i;j++)
            {
                if(dp[j]< dp[i])
                dp[i] = Math.max(dp[i],dp[j]+ a[i]);
            }
        }
        int mx = 0;
        for(int i = 0; i < n; i++)
        {
            mx = Math.max(mx,dp[i]);
        }
        return mx;
	}
}