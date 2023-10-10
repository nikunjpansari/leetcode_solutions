//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int A = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.rectangleCount(A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int rectangleCount(int num){
       int count = 0;
        for(int i=1; i <= Math.sqrt(num); i++) {
          if (num % i == 0){
            if(i%2==0 && (num/i)%2==0 && num/i!=i){
                continue;
            } 
            count++;
          }
        }
        return count;
    }
}