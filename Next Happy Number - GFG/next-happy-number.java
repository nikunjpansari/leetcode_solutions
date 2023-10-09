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
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends
class Solution{

    static int happ(int n)
     {
         int ans=0;
         while(n!=0)
         {
             ans+=((n%10)*(n%10));
             n/=10;
         }
         return ans;
     }

     static boolean happy(int n)
     {
         HashSet<Integer> hs=new HashSet();
         while(n!=1)
         {
             if(hs.contains(n))
             return false;
             hs.add(n);
             n=happ(n);
         }
         return true;
         
     }

    static int nextHappy(int N)
    {
        boolean b=false;
        
        while(b==false)
        {
            N++;
            b=happy(N);
            if(b==true)
            return N;
        }
        return -1;
    }
}