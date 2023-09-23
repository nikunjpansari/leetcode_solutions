class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums)
        {
            sum += i;
        }
        int rsum = sum;
        int lsum = 0;
        for(int i=0;i<nums.length;i++)
        {
            int a = nums[i];
            rsum -= a;
            if(lsum ==rsum)
                return i;
            lsum += a;
        }
        return -1;
    }
}