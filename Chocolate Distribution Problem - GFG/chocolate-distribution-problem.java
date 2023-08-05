//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
// Time Complexity : O(N*logN)
// Space Complexity : O(1)
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int k)
    {
        Collections.sort(a);
        long min = Integer.MAX_VALUE;
        for(int i=0;i<=(n-k);i++)
        {
            if(a.get(k-1+i) - a.get(i) < min)
            min = a.get(k-1+i) - a.get(i);
        }
        return min;
    }
}