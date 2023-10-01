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
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends

class Solution
{
   public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            
            while (j < s.length() && s.charAt(j) != '.') {
                j++;
            }
            
            result.append(reverse(s.substring(i, j)));
            
            if (j < s.length()) {
                result.append('.');
            }
            
            i = j + 1;
        }
        
        return result.toString();
    }
    
    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        
        while (j > i) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        
        return new String(chars);
    }
}