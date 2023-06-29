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
            System.out.println(ob.isHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
  
     static int isHappy(int n) { 
          if(n<=0) 
            return 0;
        while(true){
            int sum=0;
            while(n!=0){
              sum+=(n%10)*(n%10);
              n=n/10;
            }
            if(sum/10==0){
               if(sum==1||sum==7) return 1;
               else return 0;
            }
            n=sum;
        }
     }
}