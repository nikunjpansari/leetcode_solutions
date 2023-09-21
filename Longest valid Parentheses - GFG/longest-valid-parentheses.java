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
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
       int count=0;
        Stack<Integer> st = new Stack<>();
        int left = -1;
        int max =0;
        for(int i=0;i< s.length();i++)
        {
            if(s.charAt(i)=='(') 
            st.push(i);
            else 
            {
                if(st.isEmpty()) 
                left = i;
                else
                {
                    st.pop();
                    if(st.isEmpty()) 
                    max = Math.max(max,i-left);
                    else 
                    max = Math.max(max,i-st.peek());
                }
                
            }
        }
        return max;
    }
}