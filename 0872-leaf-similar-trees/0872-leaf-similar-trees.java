class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
		 return traverse(root1).equals(traverse(root2));
     }
	 String traverse(TreeNode root)
     {
		 if(root==null) 
         return "";
         
		 if(root.left==null && root.right==null) 
         return root.val+"-";  

		 return traverse(root.left)+traverse(root.right);
     }
}