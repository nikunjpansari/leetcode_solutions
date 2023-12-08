class Solution {
    StringBuilder sb;
    private void solve(TreeNode root)
    {
        if(root == null)
        return;

        if(root.left == null && root.right==null)
        {
            sb.append(root.val);
            return;
        }
        
        sb.append(root.val);
        sb.append('(');
        solve(root.left);
        sb.append(')');
        if(root.right!=null){
        sb.append('(');
        solve(root.right);
        sb.append(')');
        }
        return;
    }
    public String tree2str(TreeNode t) 
    {
        sb = new StringBuilder();
        solve(t);
        return sb.toString();
    }
}