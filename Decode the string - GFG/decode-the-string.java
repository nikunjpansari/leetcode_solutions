//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private static String getMultiplierString(String numString , String s){
        int ntimes = Integer.parseInt(numString);
        String ans="";
        for(int i=0;i<ntimes;i++){
            ans+=s;
        }
        return ans;
    }
    static String decodedString(String s){
        
        Stack<String> stack =new Stack<>();
        int n =s.length();
       
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch==']'){
                 String ans  ="";
                while(!stack.isEmpty() && stack.peek().charAt(0)!='['){
                    ans = stack.peek()+ans;
                    stack.pop();
                }
                stack.pop();
                String numString  ="";
                while(!stack.isEmpty() && stack.peek().charAt(0)>='0' &&stack.peek().charAt(0)<='9' ){
                    numString =  stack.peek()+numString;
                    stack.pop();
                }
                
                 stack.push(getMultiplierString(numString , ans));
                
                
                
            }
            else stack.push(""+ch);
        }
        
     String ans = "";
     while(!stack.isEmpty()){
         ans = stack.peek()+ans;
         stack.pop();
     }
     return ans;
       
    }
}