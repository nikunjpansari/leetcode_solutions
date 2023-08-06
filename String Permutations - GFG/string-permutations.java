//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java
// Time Complexity : O(N!)
// Space Complexity : O(N)
class Solution
{
   public ArrayList<String> permutation(String S) {
        ArrayList<String> ans = new ArrayList<>();
        backtrack(S, new StringBuilder(), new boolean[S.length()], ans);
        Collections.sort(ans);
        return ans;
    }

    private void backtrack(String S, StringBuilder cur, boolean[] vis, ArrayList<String> ans) {
        if (cur.length() == S.length()) {
            ans.add(cur.toString());
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (!vis[i]) {
                cur.append(S.charAt(i));
                vis[i] = true;
                backtrack(S, cur, vis, ans);
                vis[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
	   
}
