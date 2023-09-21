class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;

        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(inorder[i],i);
        }
        TreeNode root = solve(inorder,0,n-1,postorder,0,m-1,mp);
        return root;
    }
    public TreeNode solve(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,Map<Integer,Integer> mp)
    {
        if(inStart > inEnd || postStart > postEnd)
        return null;

        TreeNode root =  new TreeNode(postorder[postEnd]);

        int inRoot = mp.get(root.val);
        int numsRight = inEnd - inRoot;

        root.right = solve(inorder,inRoot+1,inEnd,postorder,postEnd - numsRight,postEnd-1,mp);
        root.left = solve(inorder,inStart,inRoot -1,postorder,postStart,postEnd - numsRight -1,mp);


    return root;
    }
}