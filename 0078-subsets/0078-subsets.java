class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solve(nums,0,curr,res);
        return res;
    }
    public void solve(int[] nums,int i,List<Integer> curr,List<List<Integer>> res)
    {
        if(i == nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        solve(nums,i+1,curr,res);
        curr.remove(curr.size()-1);
        solve(nums,i+1,curr,res);
    }
}