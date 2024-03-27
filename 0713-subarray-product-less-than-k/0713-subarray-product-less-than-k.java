class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1 ;
        int i = 0 ,cnt = 0;
        int n = nums.length;
        for(int j = 0;j<n;j++)
        {
            prod *= nums[j];
            while(prod >= k && i <= j)
            {
                prod /= nums[i];
                i++;
            }
            cnt += (j-i+1);
        }
        return cnt;
    }
}