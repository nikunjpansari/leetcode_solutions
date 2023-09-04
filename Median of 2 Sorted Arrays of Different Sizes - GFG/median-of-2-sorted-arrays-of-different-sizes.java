//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    public static double medianOfArrays(int n, int m, int a[], int b[]) {
    if (n > m) return medianOfArrays(m, n, b, a);

    int left = (n + m + 1) / 2;

    int low = 0, high = n;
    while (low <= high) {
        int mid1 = (low + high) / 2;
        int mid2 = left - mid1;

        int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
        int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
        int r1 = (mid1 < n) ? a[mid1] : Integer.MAX_VALUE;
        int r2 = (mid2 < m) ? b[mid2] : Integer.MAX_VALUE;

        if (l1 <= r2 && l2 <= r1) {
            if ((n + m) % 2 == 1) return Math.max(l1, l2);
            else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
        } else if (l1 > r2) high = mid1 - 1;
        else low = mid1 + 1;
    }
    return 0;
}

}