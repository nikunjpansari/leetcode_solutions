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
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends



class Solution
{
    long substrCount (String s, int k) {
       int n = s.length();
       long ans = solve(s,k,n) - solve(s,k-1,n);
       return ans;
    }
    private long solve(String s, int k, int n)
    {
    
        int i = 0 , j = 0;
        int[] a = new int[26];
        
        long res = 0;
        int d = 0;
        while(j < n)
        {
            a[s.charAt(j) - 'a']++;
            if(a[s.charAt(j) - 'a'] == 1)
            d++;
            
            while(d > k)
            {
               if(a[s.charAt(i) - 'a'] == 1)
               {
                   d--;
                   a[s.charAt(i) - 'a']--;
               }
               else
               a[s.charAt(i) - 'a']--;
               i++;
            }
            
            res += (j-i+1);
            j++;
        }
        
        return res;
    }
}