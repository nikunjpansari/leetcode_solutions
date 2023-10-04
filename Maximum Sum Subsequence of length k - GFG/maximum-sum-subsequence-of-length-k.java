//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine();
            String[] S  =s.split(" "); 
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            String s1 = br.readLine();
            String []s2 = s1.split(" ");
            int[] a = new int[n];
            for( int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s2[i]);
            Solution ob = new Solution();
            int res  = ob.max_sum(a, k);
            System.out.println(res);
        }
	}
}
// } Driver Code Ends


class Solution
{
    public int max_sum(int[] a, int k) {
        return solve(a, k, 0, -1) < 0 ? -1 : solve(a, k, 0, -1);
    }

    private int solve(int[] a, int k, int i, int prev) {
        if (k < 0) {
            return Integer.MIN_VALUE;
        }
        if (i >= a.length) {
            if (k == 0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        int ans = Integer.MIN_VALUE;

        if (prev == -1) 
        {
            int temp1 = a[i] + solve(a, k - 1, i + 1, i);
            int temp2 = solve(a, k, i + 1, prev);
            ans = Math.max(ans, Math.max(temp1, temp2));
        } else 
        {
            if (a[prev] <= a[i] && k > 0) {
                int temp1 = a[i] + solve(a, k - 1, i + 1, i);
                int temp2 = solve(a, k, i + 1, prev);
                ans = Math.max(ans, Math.max(temp1, temp2));
            } else {
                ans = Math.max(ans, solve(a, k, i + 1, prev));
            }
        }
        return ans;
    }
}

