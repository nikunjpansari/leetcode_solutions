//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
// Time Complexity : O(N)
// Space Complexity : O(no of characters)
class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
       HashMap<Character,Integer> mm = new HashMap<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            mm.putIfAbsent(c,0);
            mm.put(c,mm.get(c)+1);
        }
        for(int i=0;i<S.length();i++){
            if(mm.get(S.charAt(i))==1)
            return S.charAt(i);
        }
        return '$';
    }
}

