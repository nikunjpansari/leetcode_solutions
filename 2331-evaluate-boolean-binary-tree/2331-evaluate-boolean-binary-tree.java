class Solution {
   public boolean evaluateTree(TreeNode root) {
        if(root.val == 0) 
        return false;
        if(root.val == 1) 
        return true;
        boolean l = evaluateTree(root.left);
        boolean r = evaluateTree(root.right);
        return root.val==2 ? l|r : l&r;
    }
}