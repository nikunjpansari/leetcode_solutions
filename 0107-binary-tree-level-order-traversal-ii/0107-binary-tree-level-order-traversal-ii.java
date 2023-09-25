class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root,0,res);
        Collections.reverse(res);
        return res;
    }
    public void solve(TreeNode root,int l,List<List<Integer>> res)
    {
        if(root == null)
        return;

        if(res.size()==l)
        res.add(new ArrayList<>());

        res.get(l++).add(root.val);
        solve(root.left,l,res);
        solve(root.right,l,res);
    }
}