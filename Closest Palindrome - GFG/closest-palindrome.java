//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            long num = Long.parseLong(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.closestPalindrome(num);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   public long closestPalindrome(long num) {
    long S = previous(String.valueOf(num).toCharArray());
    long L = next(String.valueOf(num).toCharArray());
    
    long diffS = Math.abs(S - num);
    long diffL = Math.abs(L - num);
    
    if (diffS < diffL || (diffS == diffL && S < L)) {
        return S;
    }else {
        return L;
    }
}

private long previous(char[] s) {
    for (int i = 0, n = s.length; i < (n >> 1); i++) {
        while (s[i] != s[n - 1 - i]) {
            decrement(s, n - 1 - i);
            if (s[0] == '0') return Long.parseLong(new String(s));
        }
    }
    return Long.parseLong(new String(s));
}

private void decrement(char[] s, int i) {
    while (s[i] == '0') s[i--] = '9';
    s[i]--;
}

private long next(char[] s) {
    for (int i = 0, n = s.length; i < (n >> 1); i++) {
        while (s[i] != s[n - 1 - i]) {
            increment(s, n - 1 - i);
        }
    }
    return Long.parseLong(new String(s));
}

private void increment(char[] s, int i) {
    while (s[i] == '9') s[i--] = '0';
    s[i]++;
}


}