//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends

// Time Complexity: O(sqrt(N))
// Space Complexity: O(1)
//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N)
    {
        for(int i=2; i<=Math.sqrt(N); i++)
        {
            if(N%i == 0)
            {
                N = N/i;
                i--;
            }
        }
        return N;
    }
}