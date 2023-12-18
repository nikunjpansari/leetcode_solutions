class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int k = (nums[0]*nums[1]);
        int l = (nums[nums.length-1] * nums[nums.length-2]);
        return Math.abs(l-k);
    }
}