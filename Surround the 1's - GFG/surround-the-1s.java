//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   public boolean isSurrounded(int i, int j, int n, int m, int[][] matrix){
        int count = 0;
        
        int x = i - 1, y = j - 1;
        if(x >= 0 && y >= 0 && matrix[x][y] == 0){
            count++;
        }
        
        y = j;
        if(x >= 0 && matrix[x][y] == 0){
            count++;
        }
        
        y = j + 1;
        if(x >= 0 && y < m && matrix[x][y] == 0){
            count++;
        }
        
        x = i;
        y = j - 1;
        if(y >= 0 && matrix[x][y] == 0){
            count++;
        }
        
        y = j + 1;
        if(y < m && matrix[x][y] == 0){
            count++;
        }
        
        x = i + 1;
        y = j - 1;
        if(x < n && y >= 0  && matrix[x][y] == 0){
            count++;
        }
        
        y = j;
        if(x < n && matrix[x][y] == 0){
            count++;
        }
        
        y = j + 1;
        if(x < n && y < m && matrix[x][y] == 0){
            count++;
        }
        
        if(count != 0 && count % 2 == 0){
            // System.out.println(count);
            return true;
        }
        
        return false;
    }
    
    public int Count(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1 && isSurrounded(i, j, n, m, matrix)){
                    count++;
                }
            }
        }
        
        return count;
    }
}