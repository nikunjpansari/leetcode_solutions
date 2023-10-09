class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length;i++)
        {
            if(target == nums[i])
            {
            res.add(i);
            }
        }    
        return res;
    }
}