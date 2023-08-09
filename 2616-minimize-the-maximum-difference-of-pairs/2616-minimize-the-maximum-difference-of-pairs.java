class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n - 1] - nums[0];
        while(l < r) {
            int m = l + (r - l) / 2, P = p;
            for(int i = 0; i < n - 1; i++) {
                if(nums[i + 1] - nums[i] <= m) {
                    P--;
                    i++;
                }
            }
            if(P <= 0) r = m;
            else l = m + 1;
        }
        return l;
        
    }
}