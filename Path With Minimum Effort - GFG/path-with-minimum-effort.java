//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends
class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}
class Solution {
    int MinimumEffort(int heights[][]) 
    {
        PriorityQueue<Tuple> pq = 
        new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
       
        int n = heights.length; 
        int m = heights[0].length; 

        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) 
        {
            for(int j = 0;j<m;j++) 
                dist[i][j] = (int)(1e9); 
        }
        
        dist[0][0] = 0; 
        pq.add(new Tuple(0, 0, 0)); 

        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
      
        while(pq.size() != 0) 
        {
            Tuple it = pq.peek(); 
            pq.remove(); 
            int diff = it.distance; 
            int row = it.row; 
            int col = it.col; 
         
            if(row == n-1 && col == m-1) 
            return diff; 
  
            for(int i = 0;i<4;i++) 
            {
                int newr = row + dr[i]; 
                int newc = col + dc[i];

                if(newr>=0 && newc >=0 && newr < n && newc < m)
                {
                int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff); 

                    if(newEffort < dist[newr][newc]) 
                    {
                        dist[newr][newc] = newEffort; 
                        pq.add(new Tuple(newEffort, newr, newc)); 
                    }
                }
            }
        }
     
        return 0;
    }
}