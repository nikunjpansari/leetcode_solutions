//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends

class Solution {
    String removeDups(String S) {
        Set<Character> hs = new HashSet<>();
        String res = "";
        for(int i=0;i<S.length();i++)
        {
            if(!hs.contains(S.charAt(i)))
            res += S.charAt(i);
            hs.add(S.charAt(i));
        }
        return res;
    }
}