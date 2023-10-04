class Solution {
    public int matrixSum(int[][] nums) 
    {
        int res = 0;
        int n = nums.length;
        int m = nums[0].length;

        for (int i = 0; i < n; i++) {
            Arrays.sort(nums[i]);
        }
        
        for (int i = 0; i < m; i++) 
        {
            int t = 0;
            for (int j = 0; j < n;j++) 
            {
                t = Math.max(t, nums[j][i]);
            }
            res += t;
        }
        
        return res;
    }
}