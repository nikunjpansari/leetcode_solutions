class Solution {
    public int[] resultsArray(int[] nums, int k) {
          if(k == 1)
        return nums;

        int n = nums.length;
        int[] res = new int[n-k+1];
        int cnt = 1;

        for(int i = 1 ; i < n ; i++)
        {
            if(nums[i] == nums[i-1] + 1)
            cnt++;
            else
            cnt = 1;
            if(i >= k-1)
            res[i-k+1] = (cnt >= k) ? nums[i] : -1; 
        }
        return res;
    }
}