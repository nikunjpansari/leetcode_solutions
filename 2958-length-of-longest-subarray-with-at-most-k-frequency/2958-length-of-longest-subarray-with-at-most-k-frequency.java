class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int i = 0 , res = 0, n = nums.length;
        for(int j = 0; j < n ;j++)
        {
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while(mp.get(nums[j]) > k)
                mp.put(nums[i],mp.get(nums[i++])-1);
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}