//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void booleanMatrix(int matrix[][])
    {
      int n = matrix.length;
      int m = matrix[0].length;
      
      int[] row = new int[n];
      Arrays.fill(row,-1);
      
      int[] col = new int[m];
      Arrays.fill(col,-1);
      
      for(int i=0;i<n;i++)
      {
          for(int j =0 ;j<m;j++)
          {
              if(matrix[i][j]==1)
              {
                  row[i] = 1;
                  col[j] = 1;
              }

          }
      }
      for(int i=0;i<n;i++)
      {
          for(int j =0 ;j<m;j++)
          {
              if( row[i] == 1 || col[j] == 1)
              matrix[i][j]=1;
          }
      }
    }
}