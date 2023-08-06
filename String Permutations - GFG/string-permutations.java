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
        int n = S.length();
        int[] freq = new int[n];
        Arrays.fill(freq, 0);

        help("", ans, freq, S);

        Collections.sort(ans);
        return ans;
    }

    private void help(String str, ArrayList<String> ans, int[] freq, String S) {
        if (str.length() == S.length()) {
            ans.add(str);
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (freq[i] == 0) {
                str += S.charAt(i);
                freq[i] = 1;
                help(str, ans, freq, S);
                freq[i] = 0;
                str = str.substring(0, str.length() - 1);
            }
        }
    }
}
