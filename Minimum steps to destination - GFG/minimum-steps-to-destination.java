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
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int target){
        int sum = 0;
        int cnt = 0;
        if(target==0)
        return 0;

        target=Math.abs(target);

        while(sum < target)
        {
            sum+=cnt;
            cnt+=1;
        }
        while((sum - target) % 2==1)
        {
            sum+=cnt;
            cnt+=1;
        }
        return cnt-1;
    }
}