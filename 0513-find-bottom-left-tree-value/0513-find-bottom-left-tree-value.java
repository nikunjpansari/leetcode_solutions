public class Solution {
    int ans=0, h=0;
    public int findBottomLeftValue(TreeNode root) 
    {
        solve(root, 1);
        return ans;
    }
    public void solve(TreeNode root, int depth) 
    {
        if (h<depth) 
        {
            ans=root.val;
            h=depth;
        }
        if (root.left!=null) 
        solve(root.left, depth+1);
        
        if (root.right!=null) 
        solve(root.right, depth+1);
    }
}