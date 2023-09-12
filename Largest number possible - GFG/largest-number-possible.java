//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int n, int S){
         if(n==1 && S==0) return "0";
        if(S>n*9 || S==0) return "-1";
        String s="";
        while(n>0){
            if(S>8){
                s+="9";
            n--;
            S=S-9;
            }
            else{
                s+=S+"";
                S=0;
                n--;
            }
            
        }
        return String.valueOf(s);
    }
}