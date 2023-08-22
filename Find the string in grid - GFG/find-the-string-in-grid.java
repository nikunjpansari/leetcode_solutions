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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends

// Time Complexity : O(N*N)
// Space Complexity :O(N*N)
class Solution
{
    int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; 
    int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1}; 

    boolean dfs(int x, int y, int n, int m, char[][] grid, String word) {
        for (int i = 0; i < 8; i++) {
            int lx = x + dx[i] * (word.length() - 1);
            int ly = y + dy[i] * (word.length() - 1);

            if (lx < 0 || lx >= n || ly < 0 || ly >= m)
                continue;

            int j;
            for (j = 0; j < word.length(); j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (grid[nx][ny] != word.charAt(j))
                    break;
            }
            if (j == word.length())
                return true;
        }
        return false;
    }

    public int[][] searchWord(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;

        List<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    if (dfs(i, j, n, m, grid, word)) {
                        ansList.add(new int[]{i, j});
                    }
                }
            }
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

}