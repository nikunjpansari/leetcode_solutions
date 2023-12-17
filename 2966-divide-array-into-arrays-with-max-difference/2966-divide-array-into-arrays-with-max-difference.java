class Solution {
    public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int [][] ans = new int[nums.length/3][3];
    for(int i = 2; i < nums.length; i += 3){
        if(nums[i] - nums[i-2] <= k) { 
            ans[i/3][0] = nums[i-2]; 
            ans[i/3][1] = nums[i-1]; 
            ans[i/3][2] = nums[i]; 
        }
        else 
        return new int[0][];
    }
    return ans;
}
}