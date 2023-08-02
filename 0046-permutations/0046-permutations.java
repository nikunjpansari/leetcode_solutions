// Time Complexity : O(N!)
// Space Complexity : O(N * N!)

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(), nums, result);
        return result;
    }

    private void helper(List<Integer> curr, int[] nums, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                helper(curr, nums, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
