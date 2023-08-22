//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine());
    
	    while(t > 0){
	        int n = Integer.parseInt(br.readLine());
	        Solution T = new Solution();
	        
	        System.out.println(T.excelColumn(n));
	        
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String excelColumn(int N) {
    StringBuilder result = new StringBuilder();

    while (N > 0) {
        N--;  // Decrement N to adjust to 0-based indexing
        char ch = (char) ('A' + (N % 26));
        result.insert(0, ch);  // Insert at the beginning to maintain the correct order
        N /= 26;
    }

    return result.toString();
}

}