class Solution {
   public boolean isSubtree(TreeNode root, TreeNode subRoot) {

    if(root==null) return false;
    if(subRoot==null) return true;
    return helper(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
}

boolean helper(TreeNode r,TreeNode s){

    if(r==null && s==null) return true;
    if(r==null || s==null) return false;
    return (r.val==s.val) && helper(r.left,s.left) && helper(r.right,s.right);
}   
}