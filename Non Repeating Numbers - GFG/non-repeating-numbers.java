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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java
// Time Complexity : O(N)
// Space Complexity : O(1)
// Using Bitwise operators
class Solution
{
     public int[] singleNumber(int[] arr)
    {
        int n=arr.length;
        int all=0;
        
        for(int i =0; i<n; i++)
        all = all^arr[i];
        
        //s2  rightmost set bit 
        int m = all & -all;
        
        // s3
        int g1=0; int g2=0;
        for(int i =0; i<arr.length; i++)
        {
            if((m&arr[i])==0)
                g1 ^= arr[i];
            else
                g2 ^= arr[i];
        }
        int ans[] = new int[2];
        if(g1>g2)
        {
            ans[0]=g2; 
            ans[1] = g1;
            
        }
        else
         {
             ans[0]=g1; 
             ans[1] = g2;
             
         }
         
         return ans;
    
    }
}