//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    char firstRep(String S)
    {
        int n = S.length();
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1; j < n ; j++)
            {
                if(S.charAt(i) == S.charAt(j))
                  return S.charAt(i);
            }
        }
        return '#';
    }
}