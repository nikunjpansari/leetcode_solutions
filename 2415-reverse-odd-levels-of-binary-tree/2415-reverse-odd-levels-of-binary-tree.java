class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1);
        return root;
    }
    void solve(TreeNode root1, TreeNode root2, int h)
    {
        if(root1==null) 
        return;

        if(h%2==1)
        {
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
        solve(root1.left, root2.right, h+1);
        solve(root1.right, root2.left, h+1);
    }    
}