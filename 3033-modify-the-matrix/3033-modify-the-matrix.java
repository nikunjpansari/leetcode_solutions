class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int ans[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)
        {
            int maxi=0;
            for(int j=0;j<matrix.length;j++)
            {
                maxi=Math.max(maxi,matrix[j][i]);
            }
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[j][i]==-1)
                    ans[j][i]=maxi;
                else
                    ans[j][i]=matrix[j][i];
            }
        }
        return ans;
    }
}