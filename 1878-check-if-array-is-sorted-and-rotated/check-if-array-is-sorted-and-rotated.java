class Solution {
    public boolean check(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] > nums[(i + 1) % n])
                res += 1;
        }
        return res > 1 ? false : true;
        
    }
}