//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long n = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numGame(n));
        }
    }
}
// } Driver Code Ends


class Solution {
     static Long numGame(Long n) {
        // code here
        long res = 1;
        for(long i=2; i<=n; i++) 
            res = lcm(i,res);
        
        return res;
    }
    static long lcm(long x,long y) {
        return ((x*y)/gcd(x,y)) % 1000000007;
    }
      static long gcd(long x,long y) {
        if(y == 0)
           return x;
        return gcd(y,x%y);
}
};