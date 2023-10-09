//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPerfect(N));
        }
    }
}

// } Driver Code Ends

class Solution 
{
    int isPerfect(int n) 
    {
        int tmp = n;
        int sum = 0;
        while(n > 0)
        {
            int x = n % 10;
            sum += fact(x);
            n /= 10;
        }
        if(sum == tmp)
        return 1;
        else 
        return 0;
    }
    int fact(int n)
    {
        if(n==0 || n==1)
        return 1;
        else
        return fact(n-1) * n;
    }
    
}