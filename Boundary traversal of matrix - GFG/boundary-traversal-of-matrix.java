//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends
class Solution
{
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> a=new ArrayList<>();
        
        for(int i=0;i<m;i++)
        {
            a.add(matrix[0][i]);
        }
        
        if(n!=1) 
        for(int i=1;i<n;i++)
        {
            a.add(matrix[i][m-1]);
        }
        
        
        if(n!=1) 
        for(int i=m-2;i>=0;i--)
        {
            a.add(matrix[n-1][i]);
        }
        
        if(m!=1) 
        for(int i=n-2;i>0;i--)
        {
            a.add(matrix[i][0]);
        }
        
        return a;
    }
}
