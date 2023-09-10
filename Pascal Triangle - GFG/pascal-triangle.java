//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends



// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// User function Template for Java

class Solution {
      ArrayList<Long> nthRowOfPascalTriangle(int n) 
    {
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        int mod = 1000000007;
        for(int i=0;i<n;i++)
        {
            ArrayList<Long> list =  new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    list.add((long)1);
                }
                else
                {
                    list.add((ans.get(i-1).get(j) + ans.get(i-1).get(j-1))%mod);
                }
            }
            ans.add(list);
        }
        
        return ans.get(n-1);
    }
}