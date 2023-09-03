//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int h) {
     
    int l = 1, hi = (int)1e9 + 1;
    while (l < hi) {
        int mid = l + (hi - l) / 2;
        long k = tmp(piles, h, mid);
        if (k <= h)
            hi = mid;
        else
            l = mid + 1;
    }
    if (hi > (int)1e9) 
        return -1;

    return hi;
}

static long tmp(int[] piles, int h, int mid) {
    long res = 0L;
    for (int i = 0; i < piles.length; i++) {
        res += 0L + ((piles[i]) / mid);
        if (piles[i] % mid != 0)
            res += 1;
    }
    return res;
}

}
        
