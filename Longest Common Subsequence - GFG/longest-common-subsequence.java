//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends

// Time Complexity : O(|str1|*|str2|)
// Space Complexity : O(|str1|*|str2|)

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String text1, String text2)
    {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++)
                dp[i+1][j+1] = c1[i] == c2[j]? dp[i][j] + 1 : Math.max(dp[i][j+1], dp[i+1][j]);
        }
        return dp[c1.length][c2.length];
    }
    
}