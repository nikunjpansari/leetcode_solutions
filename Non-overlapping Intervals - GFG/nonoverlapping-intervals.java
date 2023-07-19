//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int N, int intervals[][]) {
        
        Arrays.sort(intervals, (a,b) -> (a[1] - b[1]));
        int ans = 0;
        int endTime = Integer.MIN_VALUE;
        for (int i = 0;i<N;i++) 
        {
            if(intervals[i][0]<endTime) 
            ans++;
            else 
            endTime = intervals[i][1];
        }
        return ans;
    }
}
