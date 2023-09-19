//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    public static long countBits(long N) {
         long ans = 0,i=1,n=N;
        while(n!=0){
            long temp = (N+1)/(i*2);
            ans+=temp*i;
            temp = (N+1)/i;
            if(temp%2==1)ans+=(N+1)%i;
            i*=2;
            n>>=1;
        }
        return ans;
    }
}
        
