//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.divisibleByDigits(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean isDivide(String s, int m) {
    long num = 0;

    for (int i = 0; i < s.length(); i++) {
        int val = s.charAt(i) - '0';
        num = num * 10 + val;
        num = num % m;
    }

    return num % m == 0;
}

public static int divisibleByDigits(String s) {
    int n = s.length();
    int[] dp = new int[10];
    dp[1] = 1;
    int count = 0;

    for (int i = 2; i <= 9; i++) {
        if (isDivide(s, i)) {
            dp[i] = 1;
        }
    }

    for (int i = 0; i < s.length(); i++) {
        int val = s.charAt(i) - '0';

        if (val == 0) {
            continue;
        }

        if (dp[val] == 1) {
            count++;
        }
    }

    return count;
}

}