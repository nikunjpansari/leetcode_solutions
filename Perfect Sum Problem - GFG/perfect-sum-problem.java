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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends

class Solution{
	int mod=1000000007;
	
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   int dp[][]=new int[n][sum+1];
	   
	   for(int i=0;i<n;i++)
	   {
	       for(int j=0;j<=sum;j++)
	       {
	               if(i==0)
	               {
                    if(j==0 && arr[0]==0)
                    dp[i][j]= 2;
                    
                    else if(j ==0 || j==arr[0])
                    dp[i][j]= 1;
                    
                    else dp[i][j]= 0;
                    }
                    else
                    {
                    int t=dp[i-1][j];
                    int m=0;
                    
                    if(arr[i]<=j)
                    m=dp[i-1][j-arr[i]];
                     dp[i][j]=(t+m)%mod;
                    }
	       }
	   }
	   return dp[n-1][sum];
}
}