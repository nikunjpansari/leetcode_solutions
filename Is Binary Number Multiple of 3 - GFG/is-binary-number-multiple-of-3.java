//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
       int sum = 0;
       int res = 0 ;
       for (char c : s.toCharArray()) 
       {
        int x = c - '0';
        sum = ((sum * 2) + x) % 3;
        }
        res = sum % 3 ;
        if(res==0)
        return 1;
        else
        return 0;
    }
}