class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums.size(), size = 0;

        for(int i = 0; i < m; i++) {
            int n = nums.get(i).size(), x = i;
            for(int j = 0; j < n; j++) {
                if(res.size() == x) {
                    res.add(new ArrayList<>());
                }
                res.get(x).add(nums.get(i).get(j));
                x++; size++;
            }
        }
        int[] ans = new int[size];
        int idx = 0;

        for(int i = 0; i < res.size(); i++) {
            for(int j = res.get(i).size()-1; j >= 0; j--) {
                ans[idx] = res.get(i).get(j);
                idx++;
            }
        }
        return ans;
    }
}