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
	        String s = br.readLine();
	        Solution T = new Solution();
	        
	        System.out.println(T.excelColumnNumber(s));
	        
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int excelColumnNumber(String input) {

    long result = 0;
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        result = result * 26 + (c - 'A' + 1);
    }
    return (int)result;
}
}