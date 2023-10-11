//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.isGoodString(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String isGoodString(String s) 
    { 
         for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                return "NO";
            }
        }
        return "YES";
    }
} 