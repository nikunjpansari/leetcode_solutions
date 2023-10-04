class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0;i<n;i++)
        Arrays.sort(grid[i]);
    
        for(int i = 0 ;i < m; i++)
        {
            int t = 0 ;
            for(int j =0 ;j < n;j++)
            {
                t = Math.max(t,grid[j][i]);
            }
            res += t;
        }
    return res;
    }
}