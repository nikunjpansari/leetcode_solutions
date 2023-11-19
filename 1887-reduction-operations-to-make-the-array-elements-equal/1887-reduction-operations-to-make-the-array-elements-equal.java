class Solution {
    public int reductionOperations(int[] nums) {
    int res = 0, n = nums.length;
    Arrays.sort(nums);
    for (int i = n - 1; i > 0; i--)
        if (nums[i- 1] != nums[i])
            res += (n - i);
    return res;
    }
}