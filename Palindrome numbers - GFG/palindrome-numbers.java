//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Long t = Long.parseLong(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPallindrome(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long isPallindrome(long N){
       long b = 0;
       long t = 1;
       
      while (N > 0) 
      {
            long r = N % 2;
            b += r * t;
            N /= 2;
            t *= 10;
        }
    
    String s = Long.toString(b);

    StringBuilder str = new StringBuilder(s);
    str.reverse();

    if(s.equals(str.toString()))
    return 1;
    else
    return 0;
    }
}