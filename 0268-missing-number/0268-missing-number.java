class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        int sum = n * (n+1)/2;
        for(int i : nums)
        {
            res += i;
        }
        return sum - res;
    }
}