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
	   for(int ind=0;ind<n;ind++){
	       for(int s=0;s<=sum;s++){
	               if(ind==0){
                    if(s==0 && arr[0]==0)dp[ind][s]= 2;
                    else if(s==0 || s==arr[0])dp[ind][s]= 1;
                    else dp[ind][s]= 0;
                    }else{
                    
                    
                    
                    int nt=dp[ind-1][s];
                    int t=0;
                    if(arr[ind]<=s)t=dp[ind-1][s-arr[ind]];
                     dp[ind][s]=(nt+t)%mod;
                    }
	       }
	   }
	   return dp[n-1][sum];
}
}